<template>
	<div :style='{"minHeight":"100vh","padding":"78px 10px","fontSize":"15px","background":"#E2E2E2"}'>
		<el-form
			:style='{"padding":"30px 30px 111px 30px","borderColor":"#eee","borderWidth":"0px 0 0","background":"#fff","flexDirection":"column","display":"flex","borderStyle":"solid"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			label-width="180px"
		>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" readonly						placeholder="用户账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" 						placeholder="用户姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='yonghu'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in yonghuxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="年龄" prop="nianling">
					<el-input v-model="ruleForm.nianling" 						placeholder="年龄" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="身高" prop="shengao">
					<el-input v-model="ruleForm.shengao" 						placeholder="身高" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="体重" prop="tizhong">
					<el-input v-model="ruleForm.tizhong" 						placeholder="体重" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="运动习惯" prop="yundongxiguan">
					<el-input v-model="ruleForm.yundongxiguan" 						placeholder="运动习惯" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='yonghu'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="yonghutouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="手机号" prop="mobile">
					<el-input v-model="ruleForm.mobile" 						placeholder="手机号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="密保问题" prop="pquestion">
					<el-input v-model="ruleForm.pquestion" 						placeholder="密保问题" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="密保答案" prop="panswer">
					<el-input v-model="ruleForm.panswer" 						placeholder="密保答案" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='users'" label="用户名" prop="username">
					<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"50%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='users'" label="头像" prop="image">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.image?ruleForm.image:''"
						@change="usersimageUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0","margin":"20px 0 0"}'>
					<el-button class="btn3" :style='{"border":"0px solid #ccc","cursor":"pointer","padding":"0 10px","margin":"0 10px 0 0","color":"#fff","borderRadius":"4px","background":"#348CB4","width":"auto","fontSize":"16px","minWidth":"110px","height":"40px"}' type="primary" @click="onUpdateHandler">
						<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","display":"none","height":"40px"}'></span>
						提交
					</el-button>
				</el-form-item>
		</el-form>
	</div>
</template>
<script>
// 校验引入
import { 
	isIntNumer,
	isMobile,
} from "@/utils/validate";

export default {
	data() {
		return {
			ruleForm: {},
			flag: '',
			usersFlag: false,
			yonghuxingbieOptions: [],
		};
	},
	mounted() {
		var table = this.$storage.get("sessionTable");
		this.flag = table;
		this.$http({
			url: `${this.$storage.get("sessionTable")}/session`,
			method: "get"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.ruleForm = data.data;
			} else {
				this.$message.error(data.msg);
			}
		});
		this.yonghuxingbieOptions = "男,女".split(',')
	},
	methods: {
		yonghutouxiangUploadChange(fileUrls) {
			this.ruleForm.touxiang = fileUrls;
		},
		usersimageUploadChange(fileUrls) {
			this.ruleForm.image = fileUrls;
		},
		onUpdateHandler() {
			if((!this.ruleForm.yonghuzhanghao)&& 'yonghu'==this.flag){
				this.$message.error('用户账号不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'yonghu'==this.flag){
				this.$message.error('密码不能为空');
				return
			}

			if((!this.ruleForm.yonghuxingming)&& 'yonghu'==this.flag){
				this.$message.error('用户姓名不能为空');
				return
			}


			if((!this.ruleForm.xingbie)&& 'yonghu'==this.flag){
				this.$message.error('性别不能为空');
				return
			}


			if((!this.ruleForm.nianling)&& 'yonghu'==this.flag){
				this.$message.error('年龄不能为空');
				return
			}


			if( 'yonghu' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
			if((!this.ruleForm.shengao)&& 'yonghu'==this.flag){
				this.$message.error('身高不能为空');
				return
			}


			if((!this.ruleForm.tizhong)&& 'yonghu'==this.flag){
				this.$message.error('体重不能为空');
				return
			}


			if((!this.ruleForm.yundongxiguan)&& 'yonghu'==this.flag){
				this.$message.error('运动习惯不能为空');
				return
			}




			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}


			if( 'yonghu' ==this.flag && this.ruleForm.mobile&&(!isMobile(this.ruleForm.mobile))){
				this.$message.error(`手机号应输入手机格式`);
				return
			}




			if('users'==this.flag && this.ruleForm.username.trim().length<1) {
				this.$message.error(`用户名不能为空`);
				return	
			}
			if(this.flag=='users'){
				this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
			}
			this.$http({
				url: `${this.$storage.get("sessionTable")}/update`,
				method: "post",
				data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					if(this.flag=='users'){
						this.$storage.set('headportrait',this.ruleForm.image)
					}
					this.$message({
						message: "修改信息成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							window.location.reload();
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
	.el-date-editor.el-input {
		width: auto;
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
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
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
	
	.add-update-preview .btn3 {
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
			}
	
	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}
	
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
