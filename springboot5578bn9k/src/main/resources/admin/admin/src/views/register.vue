<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__backInDown" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于Hadoop的健康饮食推荐系统的设计与实现</div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
						<el-input  v-model="ruleForm.yonghuzhanghao"  autocomplete="off" placeholder="用户账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
						<el-input  v-model="ruleForm.yonghuxingming"  autocomplete="off" placeholder="用户姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('shengao')?'required':''">身高：</div>
						<el-input  v-model="ruleForm.shengao"  autocomplete="off" placeholder="身高"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('tizhong')?'required':''">体重：</div>
						<el-input  v-model="ruleForm.tizhong"  autocomplete="off" placeholder="体重"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('yundongxiguan')?'required':''">运动习惯：</div>
						<el-input  v-model="ruleForm.yundongxiguan"  autocomplete="off" placeholder="运动习惯"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item email" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mobile')?'required':''">手机号码：</div>
						<div style="display: flex;flex: 1;">
							<input v-model="ruleForm.mobile" autocomplete="off" placeholder="手机号"/>
							<button v-if="isEndFlag" type="success" class="register-code" @click="sendsmscode()">发送验证码</button>
							<button v-if="!isEndFlag" type="success" class="register-code" disabled="disabled">{{SecondToDate}}</button>
						</div>
					</el-form-item>
					<el-form-item class="list-item email-code" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mobile')?'required':''">验证码：</div>
						<el-input  v-model="smscode" autocomplete="off" placeholder="验证码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('pquestion')?'required':''">密保问题：</div>
						<el-input  v-model="ruleForm.pquestion"  autocomplete="off" placeholder="密保问题"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('panswer')?'required':''">密保答案：</div>
						<el-input  v-model="ruleForm.panswer"  autocomplete="off" placeholder="密保答案"  type="text"  />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">点击登录账号</div>
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
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            smscode:'',
			// 倒计时时间
			count: 60,
			// 倒计时定时器
			inter: null,
			// 倒计时是否结束
			isEndFlag: true,
            yonghuxingbieOptions: [],
		};
	},
	computed: {
		SecondToDate: function() {
			var time = this.count;
			if (null != time && "" != time) {
				time = parseInt(time) + "秒后重发";
			}
			return time;
		}
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					yonghuzhanghao: '',
					mima: '',
					yonghuxingming: '',
					xingbie: '',
					nianling: '',
					shengao: '',
					tizhong: '',
					yundongxiguan: '',
					touxiang: '',
					mobile: '',
					pquestion: '',
					panswer: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.nianling = [{ required: true, message: '请输入年龄', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.shengao = [{ required: true, message: '请输入身高', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.tizhong = [{ required: true, message: '请输入体重', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yundongxiguan = [{ required: true, message: '请输入运动习惯', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			if(name == 'pquestion'||name=='panswer') {
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数

		sendsmscode() {
			if(!this.ruleForm.mobile){
				this.$message.error(`手机号码不能为空`);
				return
			}
			if(this.ruleForm.mobile&&(!this.$validate.isMobile(this.ruleForm.mobile))){
				this.$message.error(`请输入正确的手机格式`);
				return
			}
			this.isEndFlag = false;
			var _this = this;
			this.inter = window.setInterval(function() {
				_this.count = _this.count - 1;
				if (_this.count <= 0) {
					window.clearInterval(_this.inter);
					_this.isEndFlag = true;
					_this.count=60;
				}
			}, 1000);
			this.$http({
				url: `${this.tableName}/sendsms?mobile=`+this.ruleForm.mobile,
				method: "get",
				params: {}
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message.success(`发送成功`);
				} else {
					this.$message.error(`服务器异常，请稍后重试`)
				}
			});
		},

		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
				this.$message.error(`用户账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `yonghu` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
				this.$message.error(`用户姓名不能为空`);
				return
			}
			if((!this.ruleForm.xingbie) && `yonghu` == this.tableName){
				this.$message.error(`性别不能为空`);
				return
			}
			if((!this.ruleForm.nianling) && `yonghu` == this.tableName){
				this.$message.error(`年龄不能为空`);
				return
			}
			if(`yonghu` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
			if((!this.ruleForm.shengao) && `yonghu` == this.tableName){
				this.$message.error(`身高不能为空`);
				return
			}
			if((!this.ruleForm.tizhong) && `yonghu` == this.tableName){
				this.$message.error(`体重不能为空`);
				return
			}
			if((!this.ruleForm.yundongxiguan) && `yonghu` == this.tableName){
				this.$message.error(`运动习惯不能为空`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`yonghu` == this.tableName && this.ruleForm.mobile &&(!this.$validate.isMobile(this.ruleForm.mobile))){
				this.$message.error(`手机号应输入手机格式`);
				return
			}
			if(`yonghu` == this.tableName ){
				url=this.tableName+"/register?smscode="+this.smscode;
				if(this.ruleForm.mobile&&(!this.$validate.isMobile(this.ruleForm.mobile))){
					this.$message.error(`请输入正确的手机格式`);
					return
				}
			}
			if((!this.smscode) && `yonghu` == this.tableName){
				this.$message.error(`验证码不能为空`);
				return
			}
			if(`yonghu` == this.tableName && this.ruleForm.pquestion==''){
				this.$message.error(`密保问题不能为空`);
				return
			}
			if(`yonghu` == this.tableName && this.ruleForm.panswer==''){
				this.$message.error(`密保答案不能为空`);
				return
			}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20241009/b1967c80349d4e6b887e8cf1a3310c01.png);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20241009/b1967c80349d4e6b887e8cf1a3310c01.png);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	.rgs-form {
		.rgs-form2 {
		padding: 40px  50px;
		margin: 0;
		background: none;
		width: 600px;
		}
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
		.title {
			padding: 0 0px;
			margin: 0 0 10px 0;
			color: #fff;
			background: none;
			font-weight: 500;
			width: 580px;
			font-size: 18px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			padding: 0 0 0 0px;
			margin: 0 0 15px 120px;
			width: calc(100% - 120px);
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
				display: block;
			}
			.lable {
				color: #FFFFFF;
				left: -120px;
				letter-spacing: 1px;
				width: 120px;
				font-size: 16px;
				position: absolute !important;
				text-align: right;
				height: 46px;
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border-radius: 0;
				padding: 0 10px;
				color: #FFFFFF;
				background: none;
				flex: 1;
				font-size: 16px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				border-style: solid;
				height: 46px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border-radius: 0;
				padding: 0 10px;
				color: #FFFFFF;
				background: none;
				flex: 1;
				font-size: 16px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				border-style: solid;
				height: 46px;
			}
			.el-input-number {
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border-radius: 0;
				padding: 0 10px;
				color: #FFFFFF;
				background: none;
				flex: 1;
				font-size: 16px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				border-style: solid;
				height: 46px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border-radius: 0;
				padding: 0 10px;
				color: #FFFFFF;
				background: none;
				flex: 1;
				font-size: 16px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				border-style: solid;
				height: 46px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border-radius: 0;
				padding: 0 10px;
				color: #FFFFFF;
				background: none;
				flex: 1;
				font-size: 16px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				border-style: solid;
				height: 46px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border-radius: 0;
				padding: 0 10px;
				color: #FFFFFF;
				background: none;
				flex: 1;
				font-size: 16px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				border-style: solid;
				height: 46px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border-radius: 0;
				padding: 0 30px;
				color: #FFFFFF;
				background: none;
				flex: 1;
				font-size: 16px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				border-style: solid;
				height: 46px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border-radius: 0;
				padding: 0 30px;
				color: #FFFFFF;
				background: none;
				flex: 1;
				font-size: 16px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				border-style: solid;
				height: 46px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				margin: 0;
				color: #999;
				background: none;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				margin: 0;
				color: #999;
				background: none;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				margin: 0;
				color: #999;
				background: none;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #FFFFFF;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 115px;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				color: #fff;
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border-radius: 0;
				padding: 0 10px;
				color: #FFFFFF;
				background: none;
				flex: 1;
				font-size: 16px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				border-style: solid;
				height: 46px;
			}
			input:focus {
				border-radius: 0;
				padding: 0 10px;
				color: #FFFFFF;
				background: none;
				flex: 1;
				font-size: 16px;
				border-color: #FFFFFF;
				border-width: 0 0 1px 0;
				border-style: solid;
				height: 46px;
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			button {
				border: 0px solid #efeff7;
				cursor: pointer;
				border-radius: 4px;
				padding: 0;
				margin: 1px 0 0;
				color: #333;
				background: #fff;
				width: 150px;
				font-size: 15px;
				height: 38px;
			}
			button:hover {
				opacity: 1;
			}
		}
		.register-btn {
			margin: 30px  0 30px 8%;
			background: none;
			display: flex;
			width: 100%;
			flex-wrap: wrap;
			height: auto;
		}
		.register-btn1 {
			width: 100%;
			order: 1;
		}
		.register-btn2 {
			margin: 0;
			width: 100%;
		}
		.r-btn {
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
		.r-btn:hover {
			border: 0px solid rgba(0, 0, 0, 1);
			opacity: 0.8;
		}
		.r-login {
			cursor: pointer;
			padding: 0;
			color: #57CAFF;
			display: inline-block;
			width: 100%;
			font-size: 15px;
			line-height: 40px;
			text-align: center;
		}
		.r-login:hover {
			opacity: 1;
		}
	}
	.idea-box2 {
		background-color: #fff;
		border-radius: 10px 0 0 10px;
		background-repeat: no-repeat;
		width: 313px;
		font-size: 16px;
		background-image: url(http://codegen.caihongy.cn/20241009/9364059b601c4b0680a041c0c9dd7fa3.png);
		background-position: center  center;
		order: -1;
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
