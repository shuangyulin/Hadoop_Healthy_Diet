<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__backInDown">
				<div class="login_form2">
					<div class="title-container">基于Hadoop的健康饮食推荐系统的设计与实现</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号：
						</div>
						<input placeholder="请输入账号：" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码：
						</div>
						<div class="password-box">
							<input placeholder="请输入密码：" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item " v-if="roles.length>1">
						<div class="lable">
							角色：
						</div>
						<div prop="loginInRole" class="list-type">
							<el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
						</div>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
				<div class="idea-box2"></div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$nextTick(()=>{
							this.$http({
								url: this.tableName + '/session',
								method: "get"
							}).then(({
								data
							}) => {
								if (data && data.code === 0) {
									if(this.tableName == 'yonghu') {
										this.$storage.set('headportrait',data.data.touxiang)
									}
									if(this.tableName == 'users') {
										this.$storage.set('headportrait',data.data.image)
									}
									this.$storage.set('userForm',JSON.stringify(data.data))
									this.$storage.set('userid',data.data.id);
								} else {
									let message = this.$message
									message.error(data.msg);
								}
								if(this.boardAuth('hasBoard','查看',this.rulesForm.role)) {
									this.$router.replace({ path: "/board" });
								}else {
									this.$router.replace({ path: "/" });
								}
							});
						})
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20241009/b1967c80349d4e6b887e8cf1a3310c01.png);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20241009/b1967c80349d4e6b887e8cf1a3310c01.png);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;

	.login_form {
		border-radius: 10px  10px 0px 10px ;
		box-shadow: inset 0px 0px 0px 0px #000;
		margin: auto ;
		z-index: 1000;
		background: rgba(0,0,0,0.3);
		display: flex;
		width: 913px;
		justify-content: space-between;
		position: relative;
		height: auto;
		.login_form2 {
			padding: 40px  50px;
			margin: 60px 0 0 0;
			flex: 1;
			background: none;
			width: 600px;
		}
		.title-container {
			padding: 0 0px;
			margin: 0 0 20px 0;
			color: #fff;
			top: 60px;
			background: none;
			font-weight: 500;
			width: 580px;
			font-size: 18px;
			line-height: 40px;
			position: absolute;
			right: 10px;
			text-align: center;
		}
		.list-item {
			padding: 0;
			margin: 20px 0 20px 10px;
			display: flex;
			width: calc(100% - 0px);
			position: relative;
			align-items: center;
			.lable {
				color: #FFFFFF;
				letter-spacing: 1px;
				width: auto;
				font-size: 14px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				line-height: 40px;
				border-style: solid;
				text-align: left;
				min-width: 60px;
				height: 40px;
			}
			input {
				padding: 0 10px;
				outline: none;
				color: #fff;
				flex: 1;
				background: none;
				font-size: 14px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				height: 40px;
			}
			input:focus {
				padding: 0 10px;
				outline: none;
				color: #fff;
				flex: 1;
				background: none;
				font-size: 14px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				height: 40px;
			}
			.password-box {
				flex: 1;
				display: flex;
				position: relative;
				align-items: center;
				input {
					padding: 0 10px;
					color: #fff;
					flex: 1;
					background: none;
					font-size: 16px;
					border-color: #FFFFFF;
					border-width: 0 0 1px 0;
					height: 41px;
				}
				input:focus {
					padding: 0 10px;
					color: #fff;
					flex: 1;
					background: none;
					font-size: 14px;
					border-color: #58CBFE;
					border-width: 0 0 1px 0;
					height: 41px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #FFFFFF;
					top: 0;
					font-size: 16px;
					line-height: 44px;
					position: absolute;
					right: 5px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
		}
		.list-type {
			padding: 0;
			margin: 0;
			background: none;
			width: calc(100% - 0px);
			border-color: #FFFFFF;
			border-width: 0 0 1px 0;
			line-height: 40px;
			border-style: solid;
			height: 40px;
			/deep/ .el-radio__input .el-radio__inner {
				background: #fff;
				border-color: #666;
			}
			/deep/ .el-radio__input.is-checked .el-radio__inner {
				background: #57CAFF;
				border-color: #57CAFF;
			}
			/deep/ .el-radio__label {
				color: #fff;
				font-size: 16px;
			}
			/deep/ .el-radio__input.is-checked+.el-radio__label {
				color: #57CAFF;
				font-size: 16px;
			}
		}
		.login-btn {
			margin: 30px 0 30px 10px;
			background: none;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 100%;
				order: 1;
			}
			.login-btn2 {
				margin: 10px 0;
				display: flex;
				width: 100%;
				justify-content: space-between;
				align-items: center;
				flex-wrap: wrap;
			}
			.login-btn3 {
				width: 100%;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				padding: 0 10px;
				margin: 20px 0 0 0;
				color: #fff;
				font-weight: 700;
				font-size: 30px;
				border-radius: 4px;
				background: linear-gradient( 137deg, #7FE7EB 0%, #57CAFF 100%);
				width: 100%;
				font-family: Source Han Sans, Source Han Sans;
				min-width: 68px;
				height: 60px;
				order: -1;
			}
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: 2px solid #B8B8B8;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px;
				margin: 0 0 10px 0;
				color: #B8B8B8;
				background: none;
				width: auto;
				font-size: 16px;
				min-width: 130px;
				height: 40px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 20px 0 10px 0;
				color: #57CAFF;
				background: none;
				width: 100%;
				font-size: 15px;
				text-align: center;
				height: 34px;
			}
			.forget:hover {
				color: #57CAFF;
				opacity: 1;
			}
		}
	}
	.idea-box2 {
		border-radius: 10px 0 0 10px;
		background-repeat: no-repeat;
		background: red;
		width: 313px;
		font-size: 16px;
		background-image: url(http://codegen.caihongy.cn/20241009/9364059b601c4b0680a041c0c9dd7fa3.png);
		background-position: center  center;
		order: -1;
	}
}

</style>
