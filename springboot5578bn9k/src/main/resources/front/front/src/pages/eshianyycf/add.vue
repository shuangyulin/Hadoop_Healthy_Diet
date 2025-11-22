<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
			>
			<el-form-item class="add-item" label="中文名" prop="cname">
				<el-input v-model="ruleForm.cname" 
					placeholder="中文名" clearable :disabled=" false  ||ro.cname"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="英文名" prop="ename">
				<el-input v-model="ruleForm.ename" 
					placeholder="英文名" clearable :disabled=" false  ||ro.ename"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="食品分类" prop="spfenlei">
				<el-input v-model="ruleForm.spfenlei" 
					placeholder="食品分类" clearable :disabled=" false  ||ro.spfenlei"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="可食部%" prop="keshibu">
				<el-input-number v-model="ruleForm.keshibu" placeholder="可食部%" :disabled=" false ||ro.keshibu"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="来源" prop="laiyuan">
				<el-input v-model="ruleForm.laiyuan" 
					placeholder="来源" clearable :disabled=" false  ||ro.laiyuan"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="产地" prop="chandi">
				<el-input v-model="ruleForm.chandi" 
					placeholder="产地" clearable :disabled=" false  ||ro.chandi"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="能量(千焦)" prop="nengliang">
				<el-input-number v-model="ruleForm.nengliang" placeholder="能量(千焦)" :disabled=" false ||ro.nengliang"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="蛋白质(克)" prop="danbaizhi">
				<el-input-number v-model="ruleForm.danbaizhi" placeholder="蛋白质(克)" :disabled=" false ||ro.danbaizhi"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="脂肪(克)" prop="zhifang">
				<el-input-number v-model="ruleForm.zhifang" placeholder="脂肪(克)" :disabled=" false ||ro.zhifang"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="碳水化合物(克)" prop="tshhw">
				<el-input-number v-model="ruleForm.tshhw" placeholder="碳水化合物(克)" :disabled=" false ||ro.tshhw"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="胆固醇(毫克)" prop="dangc">
				<el-input-number v-model="ruleForm.dangc" placeholder="胆固醇(毫克)" :disabled=" false ||ro.dangc"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="饱和脂肪酸(克)" prop="baohezhifang">
				<el-input-number v-model="ruleForm.baohezhifang" placeholder="饱和脂肪酸(克)" :disabled=" false ||ro.baohezhifang"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="反式脂肪酸(克)" prop="fanshizfs">
				<el-input-number v-model="ruleForm.fanshizfs" placeholder="反式脂肪酸(克)" :disabled=" false ||ro.fanshizfs"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="单不饱和脂肪酸(克)" prop="dbbhzfs">
				<el-input-number v-model="ruleForm.dbbhzfs" placeholder="单不饱和脂肪酸(克)" :disabled=" false ||ro.dbbhzfs"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="多不饱和脂肪酸(克)" prop="duobbhzfs">
				<el-input-number v-model="ruleForm.duobbhzfs" placeholder="多不饱和脂肪酸(克)" :disabled=" false ||ro.duobbhzfs"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="糖(克)" prop="tang">
				<el-input-number v-model="ruleForm.tang" placeholder="糖(克)" :disabled=" false ||ro.tang"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="乳糖(克)" prop="rutang">
				<el-input-number v-model="ruleForm.rutang" placeholder="乳糖(克)" :disabled=" false ||ro.rutang"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="膳食纤维(克)" prop="sanshiqw">
				<el-input-number v-model="ruleForm.sanshiqw" placeholder="膳食纤维(克)" :disabled=" false ||ro.sanshiqw"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="可溶性膳食纤维(克)" prop="kesxssqw">
				<el-input-number v-model="ruleForm.kesxssqw" placeholder="可溶性膳食纤维(克)" :disabled=" false ||ro.kesxssqw"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="不溶性膳食纤维(克)" prop="bsxssqw">
				<el-input-number v-model="ruleForm.bsxssqw" placeholder="不溶性膳食纤维(克)" :disabled=" false ||ro.bsxssqw"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="钠(毫克)" prop="jinshuna">
				<el-input-number v-model="ruleForm.jinshuna" placeholder="钠(毫克)" :disabled=" false ||ro.jinshuna"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="维生素A(微克视黄醇当量)" prop="weishengshua">
				<el-input-number v-model="ruleForm.weishengshua" placeholder="维生素A(微克视黄醇当量)" :disabled=" false ||ro.weishengshua"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="维生素D(微克)" prop="weishengshud">
				<el-input-number v-model="ruleForm.weishengshud" placeholder="维生素D(微克)" :disabled=" false ||ro.weishengshud"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="维生素E(毫克α-生育酚当量)" prop="weishengshue">
				<el-input-number v-model="ruleForm.weishengshue" placeholder="维生素E(毫克α-生育酚当量)" :disabled=" false ||ro.weishengshue"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="维生素K(微克)" prop="weishengshuk">
				<el-input-number v-model="ruleForm.weishengshuk" placeholder="维生素K(微克)" :disabled=" false ||ro.weishengshuk"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="维生素B1（硫胺素）(毫克)" prop="weishengshub1">
				<el-input-number v-model="ruleForm.weishengshub1" placeholder="维生素B1（硫胺素）(毫克)" :disabled=" false ||ro.weishengshub1"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="维生素B2（核黄素）(毫克)" prop="weishengshub2">
				<el-input-number v-model="ruleForm.weishengshub2" placeholder="维生素B2（核黄素）(毫克)" :disabled=" false ||ro.weishengshub2"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="维生素B6(毫克)" prop="weishengshub6">
				<el-input-number v-model="ruleForm.weishengshub6" placeholder="维生素B6(毫克)" :disabled=" false ||ro.weishengshub6"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="维生素B12(微克)" prop="weishengshub12">
				<el-input-number v-model="ruleForm.weishengshub12" placeholder="维生素B12(微克)" :disabled=" false ||ro.weishengshub12"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="维生素C（抗坏血酸）(毫克)" prop="weishengshuc">
				<el-input-number v-model="ruleForm.weishengshuc" placeholder="维生素C（抗坏血酸）(毫克)" :disabled=" false ||ro.weishengshuc"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="烟酸（烟酰胺）(毫克)" prop="yanshuan">
				<el-input-number v-model="ruleForm.yanshuan" placeholder="烟酸（烟酰胺）(毫克)" :disabled=" false ||ro.yanshuan"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="叶酸(微克叶酸当量)" prop="yeshuan">
				<el-input-number v-model="ruleForm.yeshuan" placeholder="叶酸(微克叶酸当量)" :disabled=" false ||ro.yeshuan"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="泛酸(毫克)" prop="fanshuan">
				<el-input-number v-model="ruleForm.fanshuan" placeholder="泛酸(毫克)" :disabled=" false ||ro.fanshuan"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="生物素(微克)" prop="shenwushu">
				<el-input-number v-model="ruleForm.shenwushu" placeholder="生物素(微克)" :disabled=" false ||ro.shenwushu"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="胆碱(毫克)" prop="danjian">
				<el-input-number v-model="ruleForm.danjian" placeholder="胆碱(毫克)" :disabled=" false ||ro.danjian"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="磷(毫克)" prop="jinshulin">
				<el-input-number v-model="ruleForm.jinshulin" placeholder="磷(毫克)" :disabled=" false ||ro.jinshulin"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="钾(毫克)" prop="jinshujia">
				<el-input-number v-model="ruleForm.jinshujia" placeholder="钾(毫克)" :disabled=" false ||ro.jinshujia"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="镁(毫克)" prop="jinshumei">
				<el-input-number v-model="ruleForm.jinshumei" placeholder="镁(毫克)" :disabled=" false ||ro.jinshumei"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="钙(毫克)" prop="jinshugai">
				<el-input-number v-model="ruleForm.jinshugai" placeholder="钙(毫克)" :disabled=" false ||ro.jinshugai"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="铁(毫克)" prop="jinshutie">
				<el-input-number v-model="ruleForm.jinshutie" placeholder="铁(毫克)" :disabled=" false ||ro.jinshutie"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="锌(毫克)" prop="jinshuxin">
				<el-input-number v-model="ruleForm.jinshuxin" placeholder="锌(毫克)" :disabled=" false ||ro.jinshuxin"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="碘(微克)" prop="jinshudian">
				<el-input-number v-model="ruleForm.jinshudian" placeholder="碘(微克)" :disabled=" false ||ro.jinshudian"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="硒(微克)" prop="jinshudxi">
				<el-input-number v-model="ruleForm.jinshudxi" placeholder="硒(微克)" :disabled=" false ||ro.jinshudxi"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="铜(毫克)" prop="jinshutong">
				<el-input-number v-model="ruleForm.jinshutong" placeholder="铜(毫克)" :disabled=" false ||ro.jinshutong"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="氟(毫克)" prop="jinshufu">
				<el-input-number v-model="ruleForm.jinshufu" placeholder="氟(毫克)" :disabled=" false ||ro.jinshufu"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="锰(毫克)" prop="jinshumeng">
				<el-input-number v-model="ruleForm.jinshumeng" placeholder="锰(毫克)" :disabled=" false ||ro.jinshumeng"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="δ-E(毫克)" prop="deltae">
				<el-input-number v-model="ruleForm.deltae" placeholder="δ-E(毫克)" :disabled=" false ||ro.deltae"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="(β-γ)-E(毫克)" prop="beitae">
				<el-input-number v-model="ruleForm.beitae" placeholder="(β-γ)-E(毫克)" :disabled=" false ||ro.beitae"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="α-E(毫克)" prop="aerfae">
				<el-input-number v-model="ruleForm.aerfae" placeholder="α-E(毫克)" :disabled=" false ||ro.aerfae"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="胡萝卜素(微克)" prop="hulubo">
				<el-input-number v-model="ruleForm.hulubo" placeholder="胡萝卜素(微克)" :disabled=" false ||ro.hulubo"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="脂肪酸（总）(克)" prop="zhifansz">
				<el-input-number v-model="ruleForm.zhifansz" placeholder="脂肪酸（总）(克)" :disabled=" false ||ro.zhifansz"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="灰分(克)" prop="huifen">
				<el-input-number v-model="ruleForm.huifen" placeholder="灰分(克)" :disabled=" false ||ro.huifen"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="水分(克)" prop="shuifen">
				<el-input-number v-model="ruleForm.shuifen" placeholder="水分(克)" :disabled=" false ||ro.shuifen"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="能量(千卡)" prop="nengliangqk">
				<el-input-number v-model="ruleForm.nengliangqk" placeholder="能量(千卡)" :disabled=" false ||ro.nengliangqk"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="详情链接" prop="xqurl">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="详情链接"
					v-model="ruleForm.xqurl">
					</el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont icon-kaitongfuwu"></span>
					<span class="text">确定</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont icon-shanchu1"></span>
					<span class="text">取消</span>
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
				baseUrl: '',
				ro:{
					cname : false,
					ename : false,
					spfenlei : false,
					keshibu : false,
					laiyuan : false,
					chandi : false,
					nengliang : false,
					danbaizhi : false,
					zhifang : false,
					tshhw : false,
					dangc : false,
					baohezhifang : false,
					fanshizfs : false,
					dbbhzfs : false,
					duobbhzfs : false,
					tang : false,
					rutang : false,
					sanshiqw : false,
					kesxssqw : false,
					bsxssqw : false,
					jinshuna : false,
					weishengshua : false,
					weishengshud : false,
					weishengshue : false,
					weishengshuk : false,
					weishengshub1 : false,
					weishengshub2 : false,
					weishengshub6 : false,
					weishengshub12 : false,
					weishengshuc : false,
					yanshuan : false,
					yeshuan : false,
					fanshuan : false,
					shenwushu : false,
					danjian : false,
					jinshulin : false,
					jinshujia : false,
					jinshumei : false,
					jinshugai : false,
					jinshutie : false,
					jinshuxin : false,
					jinshudian : false,
					jinshudxi : false,
					jinshutong : false,
					jinshufu : false,
					jinshumeng : false,
					deltae : false,
					beitae : false,
					aerfae : false,
					hulubo : false,
					zhifansz : false,
					huifen : false,
					shuifen : false,
					nengliangqk : false,
					xqurl : false,
					storeupnum : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					cname: '',
					ename: '',
					spfenlei: '',
					keshibu: '',
					laiyuan: '',
					chandi: '',
					nengliang: '',
					danbaizhi: '',
					zhifang: '',
					tshhw: '',
					dangc: '',
					baohezhifang: '',
					fanshizfs: '',
					dbbhzfs: '',
					duobbhzfs: '',
					tang: '',
					rutang: '',
					sanshiqw: '',
					kesxssqw: '',
					bsxssqw: '',
					jinshuna: '',
					weishengshua: '',
					weishengshud: '',
					weishengshue: '',
					weishengshuk: '',
					weishengshub1: '',
					weishengshub2: '',
					weishengshub6: '',
					weishengshub12: '',
					weishengshuc: '',
					yanshuan: '',
					yeshuan: '',
					fanshuan: '',
					shenwushu: '',
					danjian: '',
					jinshulin: '',
					jinshujia: '',
					jinshumei: '',
					jinshugai: '',
					jinshutie: '',
					jinshuxin: '',
					jinshudian: '',
					jinshudxi: '',
					jinshutong: '',
					jinshufu: '',
					jinshumeng: '',
					deltae: '',
					beitae: '',
					aerfae: '',
					hulubo: '',
					zhifansz: '',
					huifen: '',
					shuifen: '',
					nengliangqk: '',
					xqurl: '',
					storeupnum: '',
				},


				rules: {
					cname: [
					],
					ename: [
					],
					spfenlei: [
					],
					keshibu: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					laiyuan: [
					],
					chandi: [
					],
					nengliang: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					danbaizhi: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					zhifang: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					tshhw: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					dangc: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					baohezhifang: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					fanshizfs: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					dbbhzfs: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					duobbhzfs: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					tang: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					rutang: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					sanshiqw: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					kesxssqw: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					bsxssqw: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshuna: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					weishengshua: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					weishengshud: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					weishengshue: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					weishengshuk: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					weishengshub1: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					weishengshub2: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					weishengshub6: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					weishengshub12: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					weishengshuc: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					yanshuan: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					yeshuan: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					fanshuan: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					shenwushu: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					danjian: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshulin: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshujia: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshumei: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshugai: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshutie: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshuxin: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshudian: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshudxi: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshutong: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshufu: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jinshumeng: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					deltae: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					beitae: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					aerfae: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					hulubo: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					zhifansz: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					huifen: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					shuifen: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					nengliangqk: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					xqurl: [
						{ validator: this.$validate.isURL, trigger: 'blur' },
					],
					storeupnum: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
				},
				centerType: false,
			};
		},
		computed: {



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o=='cname'){
							this.ruleForm.cname = obj[o];
							this.ro.cname = true;
							continue;
						}
						if(o=='ename'){
							this.ruleForm.ename = obj[o];
							this.ro.ename = true;
							continue;
						}
						if(o=='spfenlei'){
							this.ruleForm.spfenlei = obj[o];
							this.ro.spfenlei = true;
							continue;
						}
						if(o=='keshibu'){
							this.ruleForm.keshibu = obj[o];
							this.ro.keshibu = true;
							continue;
						}
						if(o=='laiyuan'){
							this.ruleForm.laiyuan = obj[o];
							this.ro.laiyuan = true;
							continue;
						}
						if(o=='chandi'){
							this.ruleForm.chandi = obj[o];
							this.ro.chandi = true;
							continue;
						}
						if(o=='nengliang'){
							this.ruleForm.nengliang = obj[o];
							this.ro.nengliang = true;
							continue;
						}
						if(o=='danbaizhi'){
							this.ruleForm.danbaizhi = obj[o];
							this.ro.danbaizhi = true;
							continue;
						}
						if(o=='zhifang'){
							this.ruleForm.zhifang = obj[o];
							this.ro.zhifang = true;
							continue;
						}
						if(o=='tshhw'){
							this.ruleForm.tshhw = obj[o];
							this.ro.tshhw = true;
							continue;
						}
						if(o=='dangc'){
							this.ruleForm.dangc = obj[o];
							this.ro.dangc = true;
							continue;
						}
						if(o=='baohezhifang'){
							this.ruleForm.baohezhifang = obj[o];
							this.ro.baohezhifang = true;
							continue;
						}
						if(o=='fanshizfs'){
							this.ruleForm.fanshizfs = obj[o];
							this.ro.fanshizfs = true;
							continue;
						}
						if(o=='dbbhzfs'){
							this.ruleForm.dbbhzfs = obj[o];
							this.ro.dbbhzfs = true;
							continue;
						}
						if(o=='duobbhzfs'){
							this.ruleForm.duobbhzfs = obj[o];
							this.ro.duobbhzfs = true;
							continue;
						}
						if(o=='tang'){
							this.ruleForm.tang = obj[o];
							this.ro.tang = true;
							continue;
						}
						if(o=='rutang'){
							this.ruleForm.rutang = obj[o];
							this.ro.rutang = true;
							continue;
						}
						if(o=='sanshiqw'){
							this.ruleForm.sanshiqw = obj[o];
							this.ro.sanshiqw = true;
							continue;
						}
						if(o=='kesxssqw'){
							this.ruleForm.kesxssqw = obj[o];
							this.ro.kesxssqw = true;
							continue;
						}
						if(o=='bsxssqw'){
							this.ruleForm.bsxssqw = obj[o];
							this.ro.bsxssqw = true;
							continue;
						}
						if(o=='jinshuna'){
							this.ruleForm.jinshuna = obj[o];
							this.ro.jinshuna = true;
							continue;
						}
						if(o=='weishengshua'){
							this.ruleForm.weishengshua = obj[o];
							this.ro.weishengshua = true;
							continue;
						}
						if(o=='weishengshud'){
							this.ruleForm.weishengshud = obj[o];
							this.ro.weishengshud = true;
							continue;
						}
						if(o=='weishengshue'){
							this.ruleForm.weishengshue = obj[o];
							this.ro.weishengshue = true;
							continue;
						}
						if(o=='weishengshuk'){
							this.ruleForm.weishengshuk = obj[o];
							this.ro.weishengshuk = true;
							continue;
						}
						if(o=='weishengshub1'){
							this.ruleForm.weishengshub1 = obj[o];
							this.ro.weishengshub1 = true;
							continue;
						}
						if(o=='weishengshub2'){
							this.ruleForm.weishengshub2 = obj[o];
							this.ro.weishengshub2 = true;
							continue;
						}
						if(o=='weishengshub6'){
							this.ruleForm.weishengshub6 = obj[o];
							this.ro.weishengshub6 = true;
							continue;
						}
						if(o=='weishengshub12'){
							this.ruleForm.weishengshub12 = obj[o];
							this.ro.weishengshub12 = true;
							continue;
						}
						if(o=='weishengshuc'){
							this.ruleForm.weishengshuc = obj[o];
							this.ro.weishengshuc = true;
							continue;
						}
						if(o=='yanshuan'){
							this.ruleForm.yanshuan = obj[o];
							this.ro.yanshuan = true;
							continue;
						}
						if(o=='yeshuan'){
							this.ruleForm.yeshuan = obj[o];
							this.ro.yeshuan = true;
							continue;
						}
						if(o=='fanshuan'){
							this.ruleForm.fanshuan = obj[o];
							this.ro.fanshuan = true;
							continue;
						}
						if(o=='shenwushu'){
							this.ruleForm.shenwushu = obj[o];
							this.ro.shenwushu = true;
							continue;
						}
						if(o=='danjian'){
							this.ruleForm.danjian = obj[o];
							this.ro.danjian = true;
							continue;
						}
						if(o=='jinshulin'){
							this.ruleForm.jinshulin = obj[o];
							this.ro.jinshulin = true;
							continue;
						}
						if(o=='jinshujia'){
							this.ruleForm.jinshujia = obj[o];
							this.ro.jinshujia = true;
							continue;
						}
						if(o=='jinshumei'){
							this.ruleForm.jinshumei = obj[o];
							this.ro.jinshumei = true;
							continue;
						}
						if(o=='jinshugai'){
							this.ruleForm.jinshugai = obj[o];
							this.ro.jinshugai = true;
							continue;
						}
						if(o=='jinshutie'){
							this.ruleForm.jinshutie = obj[o];
							this.ro.jinshutie = true;
							continue;
						}
						if(o=='jinshuxin'){
							this.ruleForm.jinshuxin = obj[o];
							this.ro.jinshuxin = true;
							continue;
						}
						if(o=='jinshudian'){
							this.ruleForm.jinshudian = obj[o];
							this.ro.jinshudian = true;
							continue;
						}
						if(o=='jinshudxi'){
							this.ruleForm.jinshudxi = obj[o];
							this.ro.jinshudxi = true;
							continue;
						}
						if(o=='jinshutong'){
							this.ruleForm.jinshutong = obj[o];
							this.ro.jinshutong = true;
							continue;
						}
						if(o=='jinshufu'){
							this.ruleForm.jinshufu = obj[o];
							this.ro.jinshufu = true;
							continue;
						}
						if(o=='jinshumeng'){
							this.ruleForm.jinshumeng = obj[o];
							this.ro.jinshumeng = true;
							continue;
						}
						if(o=='deltae'){
							this.ruleForm.deltae = obj[o];
							this.ro.deltae = true;
							continue;
						}
						if(o=='beitae'){
							this.ruleForm.beitae = obj[o];
							this.ro.beitae = true;
							continue;
						}
						if(o=='aerfae'){
							this.ruleForm.aerfae = obj[o];
							this.ro.aerfae = true;
							continue;
						}
						if(o=='hulubo'){
							this.ruleForm.hulubo = obj[o];
							this.ro.hulubo = true;
							continue;
						}
						if(o=='zhifansz'){
							this.ruleForm.zhifansz = obj[o];
							this.ro.zhifansz = true;
							continue;
						}
						if(o=='huifen'){
							this.ruleForm.huifen = obj[o];
							this.ro.huifen = true;
							continue;
						}
						if(o=='shuifen'){
							this.ruleForm.shuifen = obj[o];
							this.ro.shuifen = true;
							continue;
						}
						if(o=='nengliangqk'){
							this.ruleForm.nengliangqk = obj[o];
							this.ro.nengliangqk = true;
							continue;
						}
						if(o=='xqurl'){
							this.ruleForm.xqurl = obj[o];
							this.ro.xqurl = true;
							continue;
						}
						if(o=='storeupnum'){
							this.ruleForm.storeupnum = obj[o];
							this.ro.storeupnum = true;
							continue;
						}
					}
				}else if(type=='edit'){
					this.info()
				}

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`eshianyycf/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				if(!this.ruleForm.id) {
					delete this.ruleForm.userid
				}
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
							}
						}


						await this.$http.post(`eshianyycf/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
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
				this.$router.go(-1);
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 20px 16%;
		margin: 0px auto;
		background: #F2F3F7;
		width: 100%;
		position: relative;
		.add-update-form {
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				padding: 10px;
				margin: 0 0 10px;
				background: none;
				display: inline-block;
				width: 48%;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #666;
					font-weight: 500;
					width: 150px;
					font-size: 14px;
					line-height: 40px;
					text-align: center;
				}
				/deep/ .el-form-item__content {
					margin-left: 150px;
				}
				.el-input {
					width: 100%;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #E2E3E5;
					border-radius: 0;
					padding: 0 12px;
					box-shadow: 0 0 0px rgba(64, 158, 255, .5);
					outline: none;
					color: #000;
					width: 80%;
					font-size: 15px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 1px solid #E2E3E5;
					cursor: not-allowed;
					border-radius: 0;
					padding: 0 12px;
					box-shadow: 0 0 0px rgba(85, 85, 127, 0.5);
					outline: none;
					color: #000;
					background: #f8f8f8;
					width: 80%;
					font-size: 15px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #E2E3E5;
					border-radius: 0;
					padding: 0 12px;
					box-shadow: 0 0 0px rgba(64, 158, 255, .5);
					outline: none;
					color: #000;
					width: 80%;
					font-size: 15px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 1px solid #E2E3E5;
					cursor: not-allowed;
					border-radius: 0;
					padding: 0 12px;
					box-shadow: 0 0 0px rgba(85, 85, 127, 0.5);
					outline: none;
					color: #000;
					background: #f8f8f8;
					width: 80%;
					font-size: 15px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input-number__decrease {
					display: none;
				}
				.el-input-number /deep/ .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: 80%;
				}
				.el-select /deep/ .el-input__inner {
					border: 1px solid #E2E3E5;
					border-radius: 0;
					padding: 0 10px;
					box-shadow: 0 0 0px rgba(64, 158, 255, .5);
					outline: none;
					color: #000;
					width: 100%;
					font-size: 15px;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 1px solid #E2E3E5;
					cursor: not-allowed;
					border-radius: 0;
					padding: 0 10px;
					box-shadow: 0 0 0px rgba(85, 85, 127, 0.5);
					outline: none;
					color: #000;
					background: #f8f8f8;
					width: 100%;
					font-size: 15px;
					height: 40px;
				}
				.el-date-editor {
					width: 80%;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #E2E3E5;
					border-radius: 0;
					padding: 0 10px 0 30px;
					box-shadow: 0 0 0px rgba(64, 158, 255, .5);
					outline: none;
					color: #000;
					width: 100%;
					font-size: 15px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 1px solid #E2E3E5;
					cursor: not-allowed;
					border-radius: 0;
					padding: 0 10px 0 30px;
					box-shadow: 0 0 0px rgba(85, 85, 127, 0.5);
					outline: none;
					color: #000;
					background: #f8f8f8;
					width: 100%;
					font-size: 15px;
					height: 40px;
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
					border: 1px dashed #999;
					cursor: pointer;
					border-radius: 6px;
					color: #999;
					width: 100px;
					font-size: 32px;
					line-height: 100px;
					text-align: center;
					height: 100px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px dashed #999;
					cursor: pointer;
					border-radius: 6px;
					color: #999;
					width: 100px;
					font-size: 32px;
					line-height: 100px;
					text-align: center;
					height: 100px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px dashed #999;
					cursor: pointer;
					border-radius: 6px;
					color: #999;
					width: 100px;
					font-size: 32px;
					line-height: 100px;
					text-align: center;
					height: 100px;
				}
				/deep/ .el-upload__tip {
					color: #838fa1;
					display: none;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #E2E3E5;
					border-radius: 0;
					padding: 12px;
					box-shadow: 0 0 0px rgba(64, 158, 255, .5);
					outline: none;
					color: #000;
					width: 80%;
					font-size: 14px;
					height: 120px;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 1px solid #E2E3E5;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 12px;
					box-shadow: 0 0 0px rgba(85, 85, 127, 0.5);
					outline: none;
					color: #000;
					background: #f8f8f8;
					width: 80%;
					font-size: 14px;
					height: 120px;
				}
				/deep/ .el-input__inner::placeholder {
					color: #999;
					font-size: 14px;
				}
				/deep/ textarea::placeholder {
					color: #999;
					font-size: 14px;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: 0 0 0px rgba(75,223,201,.5);
					margin: 0;
					width: 80%;
					border-color: #ccc;
					border-width: 0;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					width: 100px;
					height: 100px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 10px;
					margin: 0;
					color: #fff;
					display: inline-block;
					font-size: 14px;
					line-height: 30px;
					border-radius: 4px;
					outline: none;
					background: #5AC3B2;
					width: auto;
					height: 30px;
				}
				.viewBtn:hover {
					color: #fff;
					background: #5AC3B290;
				}
				.unviewBtn {
					border: 0;
					cursor: not-allowed;
					padding: 0 10px;
					margin: 0;
					color: #ccc;
					display: inline-block;
					font-size: 14px;
					line-height: 30px;
					border-radius: 4px;
					outline: none;
					background: #858585;
					width: auto;
					height: 30px;
				}
				.unviewBtn:hover {
					color: #ccc;
					background: #858585;
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 0;
				.submitBtn {
					border: 0;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 15px;
					margin: 0 20px 0 0;
					outline: none;
					background: #5AC3B2;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 30px;
					height: 30px;
					.icon {
						color: rgba(255, 255, 255, 1);
						display: none;
					}
					.text {
						color: rgba(255, 255, 255, 1);
					}
				}
				.submitBtn:hover {
					background: #5AC3B290;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.closeBtn {
					border: 0px solid rgba(64, 158, 255, 1);
					cursor: pointer;
					padding: 0 15px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 14px;
					line-height: 30px;
					border-radius: 4px;
					outline: none;
					background: #858585;
					width: auto;
					text-align: center;
					min-width: 100px;
					height: 30px;
					.icon {
						color: #fff;
						display: none;
					}
					.text {
						color: #fff;
					}
				}
				.closeBtn:hover {
					background: #85858590;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
