<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="标题" prop="title" >
					<el-input v-model="ruleForm.title" placeholder="标题" clearable  :readonly="ro.title"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="标题" prop="title" >
					<el-input v-model="ruleForm.title" placeholder="标题" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="类型" prop="type" >
					<el-select :disabled="ro.type" v-model="ruleForm.type" placeholder="请选择类型" >
						<el-option
							v-for="(item,index) in typeOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="类型" prop="type" >
					<el-input v-model="ruleForm.type"
						placeholder="类型" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="提醒时间" prop="remindtime" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.remindtime" 
						type="datetime"
						:readonly="ro.remindtime"
						placeholder="提醒时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.remindtime" label="提醒时间" prop="remindtime" >
					<el-input v-model="ruleForm.remindtime" placeholder="提醒时间" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="textarea" v-if="type!='info'" label="简介" prop="brief" >
				<el-input
					style="min-width: 200px; max-width: 600px;"
					type="textarea"
					:rows="8"
					placeholder="简介"
					v-model="ruleForm.brief" >
				</el-input>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.brief" label="简介" prop="brief" >
				<span class="text">{{ruleForm.brief}}</span>
			</el-form-item>
			<el-form-item v-if="type!='info'"  label="内容" prop="content" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.content" 
					class="editor"
					myQuillEditor="content"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.content" label="内容" prop="content" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.content"></span>
			</el-form-item>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	export default {
		data() {
			return {
				id: '',
				type: '',
			
			
				ro:{
					userid : false,
					title : false,
					type : true,
					brief : false,
					content : false,
					remindtime : false,
				},
			
				ruleForm: {
					userid: '',
					title: '',
					brief: '',
					content: '',
					remindtime: '',
				},
				typeOptions: [],

				rules: {
					userid: [
						{ required: true, message: '发布人id不能为空', trigger: 'blur' },
					],
					title: [
						{ required: true, message: '标题不能为空', trigger: 'blur' },
					],
					type: [
					],
					brief: [
					],
					content: [
						{ required: true, message: '内容不能为空', trigger: 'blur' },
					],
					remindtime: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='userid'){
							this.ruleForm.userid = obj[o];
							this.ro.userid = true;
							continue;
						}
						if(o=='title'){
							this.ruleForm.title = obj[o];
							this.ro.title = true;
							continue;
						}
						if(o=='type'){
							this.ruleForm.type = obj[o];
							this.ro.type = true;
							continue;
						}
						if(o=='brief'){
							this.ruleForm.brief = obj[o];
							this.ro.brief = true;
							continue;
						}
						if(o=='content'){
							this.ruleForm.content = obj[o];
							this.ro.content = true;
							continue;
						}
						if(o=='remindtime'){
							this.ruleForm.remindtime = obj[o];
							this.ro.remindtime = true;
							continue;
						}
					}
				}
				if(this.$storage.get('sessionTable') == 'users'){
					this.ruleForm.type = '全局'
				}else{
					this.ruleForm.type = '个人'
				}
				this.typeOptions = "个人,全局".split(',')
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `popupremind/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.content = this.ruleForm.content.replace(reg,'../../../springboot5578bn9k/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					var objcross = this.$storage.getObj('crossObj');
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `popupremind/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.popupremindCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.popupremindCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 78px 10px;
		background: #E2E2E2;
	}
	.add-update-preview {
		padding: 30px 30px 111px 30px;
		flex-direction: column;
		background: #fff;
		display: flex;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 50%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #000000;
		font-weight: 400;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		border: 2px solid #000000;
		cursor: pointer;
		padding: 6px 15px;
		margin: 0 20px 0 0;
		color: #666;
		display: block;
		font-size: 15px;
		line-height: 24px;
		border-radius: 0px;
		word-break: break-all;
		background: #F4F4F4;
		width: 100%;
		text-align: left;
		height: auto;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 2px solid #000000;
		border-radius: 5px  5px  5px  5px;
		padding: 0 12px;
		color: #666;
		background: #F4F4F4;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 2px solid #000000;
		border-radius: 5px  5px  5px  5px;
		padding: 0 12px;
		color: #666;
		background: #F4F4F4;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 2px solid #000000;
		border-radius: 5px  5px  5px  5px;
		padding: 0 12px;
		color: #666;
		background: #F4F4F4;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 2px solid #000000;
		border-radius: 5px  5px  5px  5px;
		padding: 0 12px;
		color: #666;
		background: #F4F4F4;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 2px solid #000000;
		border-radius: 5px  5px  5px  5px;
		padding: 0 12px;
		color: #666;
		background: #F4F4F4;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 2px solid #000000;
		border-radius: 5px  5px  5px  5px;
		padding: 0 12px;
		color: #666;
		background: #F4F4F4;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 2px solid #000000;
		border-radius: 5px  5px  5px  5px;
		padding: 0 30px;
		color: #666;
		background: #F4F4F4;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 2px solid #000000;
		border-radius: 5px  5px  5px  5px;
		padding: 0 30px;
		color: #666;
		background: #F4F4F4;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 2px solid #000000;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #F4F4F4;
		width: auto;
		font-size: 15px;
		line-height: 40px;
		text-align: left;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 2px solid #000000;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #F4F4F4;
		width: auto;
		font-size: 15px;
		line-height: 40px;
		text-align: left;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 2px solid #000000;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #F4F4F4;
		width: auto;
		font-size: 15px;
		line-height: 40px;
		text-align: left;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 2px solid #000000;
		cursor: pointer;
		border-radius: 5px 5px 5px 5px;
		color: #666;
		background: #F4F4F4;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 2px solid #000000;
		cursor: pointer;
		border-radius: 5px 5px 5px 5px;
		color: #666;
		background: #F4F4F4;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 2px solid #000000;
		cursor: pointer;
		border-radius: 5px 5px 5px 5px;
		color: #666;
		background: #F4F4F4;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border:  2px solid #000000;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #F4F4F4;
		width: auto;
		font-size: 14px;
		min-width: 1200px;
		height: 208px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border:  2px solid #000000;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: #F4F4F4;
				width: auto;
				font-size: 14px;
				min-width: 1200px;
				height: 208px;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #66D5F8;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #EF8E6A;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #348CB4;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 2px solid #57CAFF;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #57CAFF;
			background: #fff;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 2px solid #57CAFF;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #57CAFF;
			background: #fff;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
