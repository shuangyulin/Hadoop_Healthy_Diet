<template>
	<div class="content" :style='{"alignContent":"flex-start","padding":"0 0 53px 0","overflow":"hidden","background":"url(http://codegen.caihongy.cn/20250104/f5f3c3bf499641a9ad7b02fcf340b381.png) no-repeat bottom center,url(http://codegen.caihongy.cn/20250104/74fb86808f734214b656ff6e6baff933.png) no-repeat top center,rgb(3, 12, 59)","flexDirection":"column","display":"flex","width":"100%","position":"relative","height":"100%"}'>
		<div id="particles"></div>
		<div :style='{"padding":"15px 0 0","margin":"0","background":"url(http://codegen.caihongy.cn/20250104/a6f8e90a837b4c2eb8601823d839286f.png) no-repeat top center","display":"flex","width":"100%","position":"relative","justifyContent":"center","height":"98px","zIndex":"2"}'>
			<!-- 标题 -->
			<div :style='{"margin":"0","fontSize":"20px","color":"rgb(255, 255, 255)","textAlign":"center","fontWeight":"700"}'>欢迎使用 {{this.$project.projectName}}</div>
			<!-- 时间 -->
			<div :style='{"top":"65px","color":"#d0e1f3","display":"inline-block","lineHeight":"44px","fontSize":"16px","position":"absolute","right":"12%","height":"44px"}'>{{ dates }} <span @click="backClick" style="cursor:pointer;padding: 0 0 0 8px;">管理界面</span></div>
		</div>
		<div :style='{"padding":"0","flex":"auto","background":"url(http://codegen.caihongy.cn/20250104/81d376bb600349c6bb9ee3b9e2a3bade.png) no-repeat left center / 180px 100%,url(http://codegen.caihongy.cn/20250104/faebd1e099b7458bb5291b776236cd99.png) no-repeat right center / 170px 100%","display":"flex","width":"100%","justifyContent":"space-between","height":"0","zIndex":"9"}'>
			<div :style='{"width":"28%","padding":"0","flexDirection":"column","display":"flex","gap":"10px"}'>
				<div class="echarts1">
					<div :style='{"padding":"0 0 0 30px","margin":"0 0 0 160px","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250104/98a6bbd24bd24c75a26b8a0a8f28b0ca.png) no-repeat left center / 278px 36px","flex":"none","width":"calc(100% - 160px)","height":"36px"}'>
						<div :style='{"fontSize":"20px","lineHeight":"36px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							食物词云
						</div>
					</div>
					<div :style='{"width":"100%","padding":"0 0 0 120px","flex":"auto","height":"0"}'>
						<div id="eshianyycfChart1" style="width:100%;height:100%;"></div>
					</div>
				</div>
				<div class="echarts2">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250104/98a6bbd24bd24c75a26b8a0a8f28b0ca.png) no-repeat left center / 278px 36px","flex":"none","width":"100%","height":"36px"}'>
						<div :style='{"fontSize":"20px","lineHeight":"36px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							食物类型分布
						</div>
					</div>
					<div :style='{"width":"100%","padding":"0","flex":"auto","height":"0"}'>
						<div id="eshianyycfChart2" style="width:100%;height:100%;"></div>
					</div>
				</div>
				<div class="echarts6">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250104/98a6bbd24bd24c75a26b8a0a8f28b0ca.png) no-repeat left center / 278px 36px","flex":"none","width":"100%","height":"36px"}'>
						<div :style='{"fontSize":"20px","lineHeight":"36px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							碳水化合物排名
						</div>
					</div>
					<div :style='{"width":"100%","flex":"auto","height":"0"}'>
						<div id="eshianyycfChart6" style="width:100%;height:100%;"></div>
					</div>
				</div>
			</div>
			<div :style='{"width":"44%","padding":"0 0px","flexDirection":"column","display":"flex"}'>
				<!-- 统计 -->
				<div :style='{"padding":"0 10px","margin":"0","color":"#fff","alignItems":"center","display":"flex","justifyContent":"center","alignContent":"center","background":"none","gap":"10px","width":"100%","fontSize":"14px","height":"58px","order":"1"}'>

					<div :style='{"padding":"0 10px","margin":"0","alignItems":"center","background":"url(http://codegen.caihongy.cn/20250104/9308fb76b74e4fa5be5d28c2f3ad95a4.png) no-repeat center top / 100% 100%","flexDirection":"column","flex":"1 1 auto","display":"flex","width":"150px","position":"relative","justifyContent":"center","height":"58px","maxWidth":"240px"}'>
						<div :style='{"width":"12px","margin":"0 0 0 20px","background":"#2097db","display":"none","height":"12px"}'></div>
						<div :style='{"padding":"0","alignItems":"center","flexDirection":"row","display":"flex","gap":"6px","width":"100%","justifyContent":"space-evenly","height":"100%"}'>
							<div :style='{"color":"inherit","fontSize":"14px","height":"auto"}'>营养成份总数</div>
							<div :style='{"lineHeight":"44px","fontSize":"16px","color":"rgb(66, 144, 247)","fontWeight":"bold","height":"40px","order":"20"}'>{{eshianyycfCount}}</div>
						</div>
					</div>
				</div>
				<div class="echarts7">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250104/98a6bbd24bd24c75a26b8a0a8f28b0ca.png) no-repeat left center / 278px 36px","flex":"none","width":"100%","height":"36px"}'>
						<div :style='{"fontSize":"20px","lineHeight":"36px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							营养成份
						</div>
					</div>
					<el-table id="eshianyycfTable" :data="eshianyycfList" border :stripe="false" :style='{"padding":"0","borderColor":"rgba(92,135,230,.3)","borderWidth":"1px 0 0 1px","background":"none","width":"100%","overflow-y":"scroll","borderStyle":"solid","height":"calc(100% - 36px)"}'>
						<el-table-column :resizable="true" :sortable="false" prop="cname" label="中文名">
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="ename" label="英文名">
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="spfenlei" label="食品分类">
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="chandi" label="产地">
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="nengliang" label="能量(千焦)">
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="danbaizhi" label="蛋白质(克)">
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="zhifang" label="脂肪(克)">
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="tshhw" label="碳水化合物(克)">
						</el-table-column>
					</el-table>
				</div>
			</div>
			<div :style='{"width":"28%","padding":"0","flexWrap":"wrap","flexDirection":"column","display":"flex","gap":"10px"}'>
				<div class="echarts3">
					<div :style='{"padding":"0 0 0 30px","margin":"0 0 0px","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250104/98a6bbd24bd24c75a26b8a0a8f28b0ca.png) no-repeat left center / 278px 36px","flex":"none","width":"100%","height":"36px"}'>
						<div :style='{"fontSize":"20px","lineHeight":"36px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							产地分布
						</div>
					</div>
					<div :style='{"width":"100%","padding":"0 80px 0 0","flex":"auto","height":"0"}'>
						<div id="eshianyycfChart3" style="width:100%;height:100%;"></div>
					</div>
				</div>
				<div class="echarts4">
					<div :style='{"padding":"0 0 0 30px","margin":"0 0 0px","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250104/98a6bbd24bd24c75a26b8a0a8f28b0ca.png) no-repeat left center / 278px 36px","flex":"none","width":"100%","height":"36px"}'>
						<div :style='{"fontSize":"20px","lineHeight":"36px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							能量区间
						</div>
					</div>
					<div :style='{"width":"100%","padding":"0 30px 0 0","flex":"auto","height":"0"}'>
						<div id="eshianyycfChart4" style="width:100%;height:100%;"></div>
					</div>
				</div>
				<div class="echarts5">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250104/98a6bbd24bd24c75a26b8a0a8f28b0ca.png) no-repeat left center / 278px 36px","flex":"none","width":"100%","height":"36px"}'>
						<div :style='{"fontSize":"20px","lineHeight":"36px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							蛋白质排名
						</div>
					</div>
					<div :style='{"width":"100%","padding":"0 120px 0 0","flex":"auto","height":"0"}'>
						<div id="eshianyycfChart5" style="width:100%;height:100%;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>
<script>
	import * as echarts from 'echarts'
	import chinaJson from "@/components/echarts/china.json";
	require('@/utils/particles.js')
	import router from '@/router/router-static'
	export default {
		data() {
			return {
				line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"dashed","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":30,"padding":0,"shadowOffsetX":0,"margin":10,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":120,"interval":0,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00feff","#3f83f8","#fada58","#e49207","#73D13D","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"show":false},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":3000,"symbol":"circle","animationEasing":"backOut","showSymbol":true,"symbolSize":5,"itemStyle":{"color":"","borderColor":"rgba(0,254,255,0.3)","borderWidth":8},"animation":true},"tooltip":{"backgroundColor":"#123","trigger":"axis","textStyle":{"color":"#fff"}},"title":{"show":false}},
				line2: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"dashed","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":30,"padding":0,"shadowOffsetX":0,"margin":10,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":120,"interval":0,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00feff","rgb(251, 140, 61)","rgb(59, 220, 31)","rgb(83, 207, 252)","#fac858","#3ba272","#5470c6","#ee6666","#ea7ccc"],"legend":{"show":false},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"symbol":"circle","animationEasing":"exponentialOut","showSymbol":true,"symbolSize":5,"itemStyle":{"color":"","borderColor":"rgba(0,254,255,0.3)","borderWidth":8},"animation":true},"tooltip":{"backgroundColor":"#123","trigger":"axis","textStyle":{"color":"#fff"}},"title":{"show":false}},
				line3: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"dashed","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":30,"padding":0,"shadowOffsetX":0,"margin":10,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":120,"interval":0,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00feff","rgb(251, 140, 61)","rgb(59, 220, 31)","rgb(83, 207, 252)","#fac858","#3ba272","#5470c6","#ee6666","#ea7ccc"],"legend":{"show":false},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"symbol":"circle","animationEasing":"exponentialOut","areaStyle":{"color":{"x":0,"y":0,"y2":1,"x2":0,"colorStops":[{"offset":0,"color":"rgba(0,254,255,0.5)"},{"offset":1,"color":"rgba(0,254,255,0)"}],"type":"linear"}},"showSymbol":true,"symbolSize":5,"itemStyle":{"color":"","borderColor":"rgba(0,254,255,0.3)","borderWidth":8},"animation":true},"tooltip":{"backgroundColor":"#123","trigger":"axis","textStyle":{"color":"#fff"}},"title":{"show":false}},
				line4: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"dashed","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":30,"padding":0,"shadowOffsetX":0,"margin":10,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":120,"interval":0,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00feff","rgb(251, 140, 61)","rgb(59, 220, 31)","rgb(83, 207, 252)","#fac858","#3ba272","#5470c6","#ee6666","#ea7ccc"],"legend":{"show":false},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"symbol":"circle","animationEasing":"exponentialOut","areaStyle":{"color":{"x":0,"y":0,"y2":1,"x2":0,"colorStops":[{"offset":0,"color":"rgba(0,254,255,0.5)"},{"offset":1,"color":"rgba(0,254,255,0)"}],"type":"linear"}},"showSymbol":true,"symbolSize":5,"itemStyle":{"color":"","borderColor":"rgba(0,254,255,0.3)","borderWidth":8},"animation":true},"tooltip":{"backgroundColor":"#123","trigger":"axis","textStyle":{"color":"#fff"}},"title":{"show":false}},
				line5: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"dashed","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":30,"padding":0,"shadowOffsetX":0,"margin":10,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":120,"interval":0,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00feff","rgb(251, 140, 61)","rgb(59, 220, 31)","rgb(83, 207, 252)","#fac858","#3ba272","#5470c6","#ee6666","#ea7ccc"],"legend":{"shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"itemHeight":14,"show":true,"icon":"roundRect","type":"scroll","top":"top","lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"borderWidth":0,"itemWidth":20,"shadowColor":"rgba(0,0,0,.3)","height":"auto","padding":0,"itemGap":10,"backgroundColor":"transparent","orient":"horizontal","bottom":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","borderRadius":0,"left":"center","width":"100%","textStyle":{"textBorderWidth":0,"color":"#959aa5","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0}},"grid":{"right":"20","top":"30","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"symbol":"circle","animationEasing":"exponentialOut","showSymbol":true,"symbolSize":5,"itemStyle":{"color":""},"animation":true},"series2":{"barWidth":"auto","animationDuration":6000,"colorBy":"series","animationEasing":"exponentialOut","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"barCategoryGap":"20%","animation":true},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"show":false}},
				bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":30,"padding":0,"shadowOffsetX":0,"margin":10,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":120,"interval":0,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00feff","rgb(251, 140, 61)","rgb(59, 220, 31)","rgb(83, 207, 252)","#fac858","#3ba272","#5470c6","#ee6666","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":false,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"bottom","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"center","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"itemStyle":{"borderType":"solid","shadowOffsetX":5,"borderColor":"inherit","shadowOffsetY":5,"color":{"x":0,"y":0,"y2":1,"x2":0,"colorStops":[{"offset":0,"color":"#00feff"},{"offset":0.5,"color":"#027eff"},{"offset":1,"color":"#0286ff"}],"type":"linear"},"borderRadius":[10,10,0,0],"shadowBlur":10,"borderWidth":0,"opacity":1,"shadowColor":"rgba(0, 0, 0, 0.4)"},"colorBy":"series","animationEasing":"exponentialOut","animation":true},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"show":false},"base":{"animate":true,"interval":6000}},
				bar2: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":150,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00feff","rgb(251, 140, 61)","rgb(59, 220, 31)","rgb(83, 207, 252)","#fac858","#3ba272","#5470c6","#ee6666","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":false,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"bottom","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"center","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"itemStyle":{"borderType":"solid","shadowOffsetX":5,"borderColor":"inherit","shadowOffsetY":5,"color":{"x":0,"y":0,"y2":0,"x2":1,"colorStops":[{"offset":0,"color":"#00feff"},{"offset":0.5,"color":"#027eff"},{"offset":1,"color":"#0286ff"}],"type":"linear"},"borderRadius":[0,10,10,0],"shadowBlur":10,"borderWidth":0,"opacity":1,"shadowColor":"rgba(0, 0, 0, 0.4)"},"colorBy":"series","animationEasing":"exponentialOut","animation":true},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"show":false},"base":{"animate":true,"interval":6000}},
				bar3: {"polar":{"radius":[20,"80%"]},"backgroundColor":"transparent","radiusAxis":{"type":"category"},"color":["#00feff","#3f83f8","#fada58","#e49207","#73D13D","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"show":false},"series":{"barWidth":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"coordinateSystem":"polar","label":{"formatter":"{b}: {c}","show":true,"fontSize":10,"position":"middle"},"color":{"x":0,"y":0,"y2":1,"x2":0,"colorStops":[{"offset":0,"color":"#00feff"},{"offset":0.5,"color":"#027eff"},{"offset":1,"color":"#0286ff"}],"type":"linear"},"barCategoryGap":"20%"},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"},"trigger":"axis"},"title":{"show":false},"base":{"animate":false,"interval":2000},"angleAxis":{"startAngle":90}},
				pie: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#00feff","#3f83f8","#fada58","#e49207","#73D13D","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"show":false},"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"center","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"#959aa5","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"animationDuration":4000,"animationEasing":"quadraticOut","top":30,"left":30,"bottom":30,"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"right":30,"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"#fff","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","formatter":"{d}%","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"inside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"radius":[0,"75%"],"animation":true}},
				pie2: {"tooltip":{"backgroundColor":"#123","trigger":"item","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#00feff","#3f83f8","#fada58","#e49207","#73D13D","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"show":false},"legend":{"padding":0,"itemGap":4,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"center","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":12,"textStyle":{"textBorderWidth":0,"color":"#959aa5","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"animationDuration":4000,"animationEasing":"quadraticOut","avoidLabelOverlap":false,"emphasis":{"label":{"show":false,"fontSize":40,"fontWeight":"bold"}},"itemStyle":{"borderRadius":10,"borderColor":"rgb(3, 12, 59, 0.00001)","borderWidth":10},"label":{"color":"inherit","show":false,"position":"center"},"labelLine":{"show":false},"padAngle":10,"animation":true}},
				pie3: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#00feff","#3f83f8","#fada58","#e49207","#73D13D","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"show":false},"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"center","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":14,"textStyle":{"textBorderWidth":0,"color":"#959aa5","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"rgb(3, 12, 59)","shadowOffsetY":0,"color":"","borderRadius":5,"shadowBlur":0,"borderWidth":4,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"#fff","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":true},"radius":["30%","75%"]}},
				funnel: {"backgroundColor":"transparent","color":["#3f83f8","#fada58","#e49207","#73D13D","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"grid":{"right":"30","top":"30","left":"30","bottom":"30"},"legend":{"shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"itemHeight":8,"show":true,"icon":"roundRect","type":"scroll","top":"bottom","lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"borderWidth":0,"itemWidth":14,"shadowColor":"rgba(0,0,0,.3)","height":"auto","padding":0,"itemGap":10,"backgroundColor":"transparent","orient":"horizontal","bottom":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","borderRadius":0,"left":"center","width":"100%","textStyle":{"textBorderWidth":0,"color":"#959aa5","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0}},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"gap":2},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"show":false}},
				funnel2: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#3f83f8","#fada58","#e49207","#73D13D","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"show":false},"legend":{"padding":0,"itemGap":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":14,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"gap":2}},
				funnel3: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#3f83f8","#fada58","#e49207","#73D13D","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"show":false},"legend":{"padding":0,"itemGap":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":14,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"gap":2}},
				funnel4: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#3f83f8","#fada58","#e49207","#73D13D","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"show":false},"legend":{"padding":0,"itemGap":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":14,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"gap":2}},
				funnel5: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#3f83f8","#fada58","#e49207","#73D13D","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"show":false},"legend":{"padding":0,"itemGap":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":14,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"gap":2}},
				map: {"tooltip":{"formatter":"{b} : {c}","trigger":"item"},"backgroundColor":"transparent","title":{"borderType":"solid","padding":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":false,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"aspectScale":0.75,"itemStyle":{"areaColor":"#a8d5fc"},"zoom":1.8,"label":{"emphasis":{"show":true,"textStyle":{"color":"#3ba372"}},"normal":{"color":"#3ba372","show":true}},"roam":true,"showLegendSymbol":false,"animation":false},"visualMap":{"min":0,"text":["High","Low"],"inRange":{"color":["#27b3ff","#fe9900","#57bd57","#f92f00","#01cbcf","#3ba272","#fc8452","#9a60b4","#ea7ccc"]},"max":500,"calculable":true,"seriesIndex":[0]}},
				boardBase: {"funnelNum":6,"lineNum":8,"gaugeNum":8,"barNum":8,"pieNum":6},
				gauge: {"tooltip":{"formatter":"{b} : {c}","trigger":"item"},"backgroundColor":"transparent","color":["#3f83f8","#fada58","#e49207","#73D13D","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"show":false,"textStyle":{"textBorderWidth":0,"color":"#ccc","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"top":"top","left":"left"},"series":{"pointer":{"offsetCenter":[0,"10%"],"icon":"path://M2.9,0.7L2.9,0.7c1.4,0,2.6,1.2,2.6,2.6v115c0,1.4-1.2,2.6-2.6,2.6l0,0c-1.4,0-2.6-1.2-2.6-2.6V3.3C0.3,1.9,1.4,0.7,2.9,0.7z","width":8,"length":"80%"},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"opacity":0.5,"shadowBlur":1,"shadowColor":"#000"},"roundCap":true},"anchor":{"show":true,"itemStyle":{"color":"inherit"},"size":18,"showAbove":true},"emphasis":{"disabled":false},"progress":{"show":true,"roundCap":true,"overlap":true},"splitNumber":10,"detail":{"formatter":"{value}","backgroundColor":"inherit","color":"#fff","borderRadius":3,"width":20,"fontSize":12,"height":12},"title":{"color":"#ccc","fontSize":12},"animation":true}},
				myChart0: null,
				eshianyycfList: [],
				eshianyycfTimer: null,
				dates: '',
				eshianyycfCount: 0,
				particlesJson: {"retina_detect":true,"particles":{"number":{"density":{"value_area":800,"enable":true},"value":6},"move":{"straight":true,"random":true,"bounce":false,"enable":true,"attract":{"rotateX":600,"enable":false,"rotateY":600},"speed":6,"direction":"bottom","out_mode":"out"},"color":{"value":"#fff"},"shape":{"image":{"width":20,"src":"http://codegen.caihongy.cn/20241115/e750ff1907a2423bb12d1c4fb49310dd.png","height":20},"polygon":{"nb_sides":5},"type":"image","stroke":{"color":"#000000","width":0}},"size":{"anim":{"size_min":0.1,"sync":false,"enable":false,"speed":40},"random":true,"value":10},"line_linked":{"width":1,"distance":150,"color":"#ffffff","opacity":0.4,"enable":false},"opacity":{"anim":{"opacity_min":0,"sync":false,"enable":false,"speed":30},"random":true,"value":0.5}},"interactivity":{"detect_on":"canvas","events":{"resize":true,"onclick":{"mode":"push","enable":false},"onhover":{"mode":"grab","enable":false}},"modes":{"grab":{"distance":400,"line_linked":{"opacity":1}},"bubble":{"duration":2,"distance":250,"size":0,"opacity":0,"speed":3},"repulse":{"duration":0.4,"distance":400},"push":{"particles_nb":4},"remove":{"particles_nb":2}}}}
			};
		},
		mounted(){
			this.init();
			this.geteshianyycfList()
			particlesJS('particles',this.particlesJson)
		},
		created() {
			this.$nextTick(()=>{
				this.times()
				setTimeout(()=>{
					this.geteshianyycfCount();
					this.eshianyycfChat1();
					this.eshianyycfChat2();
					this.eshianyycfChat3();
					this.eshianyycfChat4();
					this.eshianyycfChat5();
					this.eshianyycfChat6();
				},500)
			})
		},
		methods:{
			geteshianyycfList() {
				let params = {
					page: 1,
					limit: 20,
				}
				this.$http({
					url: "eshianyycf/page",
					method: "get",
					params: params
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.eshianyycfList = data.data.list;
						let div = document.getElementById('eshianyycfTable')
						var scrollTop = -1
						function move() {
							if (div){
								if(div.scrollTop==scrollTop){
									div.scrollTo({
										top: 0, 
										behavior: "smooth"
									});
									return false
								}
								scrollTop = div.scrollTop
								div.scrollTo({ 
									top: div.scrollTop + 40, 
									behavior: "smooth"
								});
							}
								
						}
						this.eshianyycfTimer = setInterval(move, 2000);
						div.addEventListener('mouseenter', e => {
							e.stopPropagation()
							clearInterval(this.eshianyycfTimer);
						})
						div.addEventListener('mouseleave', e => {
							e.stopPropagation()
							this.eshianyycfTimer = setInterval(move, 2000);
						})
					}
				});
			},
			backClick(){
				this.$router.replace({ path: "/" });
			},
			myChartInterval(type, xAxisData, seriesData, myChart) {
				this.$nextTick(() => {
					setInterval(() => {
						let xAxis = xAxisData.shift()
						xAxisData.push(xAxis)
						let series = seriesData.shift()
						seriesData.push(series)
			
						if (type == 1) {
							myChart.setOption({
								xAxis: [{
									data: xAxisData
								}],
								series: [{
									data: seriesData
								}]
							});
						}
						if (type == 2) {
							myChart.setOption({
								yAxis: [{
									data: xAxisData
								}],
								series: [{
									data: seriesData
								}]
							});
						}
					}, 6000);
				})
			},
			wordclouds(wordcloudData,echartsId) {
				let wordcloud = {"maskImage":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAA28AAAJHCAYAAAAHR24TAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAGsmlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNy4xLWMwMDAgMTE2LjM5YWJhZjcsIDIwMjIvMDIvMjUtMjE6NTc6MjEgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIiB4bWxuczpwaG90b3Nob3A9Imh0dHA6Ly9ucy5hZG9iZS5jb20vcGhvdG9zaG9wLzEuMC8iIHhtbG5zOnhtcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIiB4bWxuczpzdEV2dD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL3NUeXBlL1Jlc291cmNlRXZlbnQjIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCAyMi41IChXaW5kb3dzKSIgeG1wOkNyZWF0ZURhdGU9IjIwMjMtMTEtMjVUMTc6MTg6NDErMDg6MDAiIHhtcDpNb2RpZnlEYXRlPSIyMDIzLTExLTI4VDA5OjEwOjEyKzA4OjAwIiB4bXA6TWV0YWRhdGFEYXRlPSIyMDIzLTExLTI4VDA5OjEwOjEyKzA4OjAwIiBkYzpmb3JtYXQ9ImltYWdlL3BuZyIgcGhvdG9zaG9wOkNvbG9yTW9kZT0iMyIgcGhvdG9zaG9wOklDQ1Byb2ZpbGU9InNSR0IgSUVDNjE5NjYtMi4xIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjZmNzMwYTI4LTQ5NjUtYzU0Mi05ZTcxLTkwYjg3NTlmMDliNiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpmZmJmODcwOC03ZWIwLTQxNGYtYTU3ZS1mNWVmY2QyNDNmN2QiIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDpmZmJmODcwOC03ZWIwLTQxNGYtYTU3ZS1mNWVmY2QyNDNmN2QiPiA8eG1wTU06SGlzdG9yeT4gPHJkZjpTZXE+IDxyZGY6bGkgc3RFdnQ6YWN0aW9uPSJjcmVhdGVkIiBzdEV2dDppbnN0YW5jZUlEPSJ4bXAuaWlkOmZmYmY4NzA4LTdlYjAtNDE0Zi1hNTdlLWY1ZWZjZDI0M2Y3ZCIgc3RFdnQ6d2hlbj0iMjAyMy0xMS0yNVQxNzoxODo0MSswODowMCIgc3RFdnQ6c29mdHdhcmVBZ2VudD0iQWRvYmUgUGhvdG9zaG9wIDIyLjUgKFdpbmRvd3MpIi8+IDxyZGY6bGkgc3RFdnQ6YWN0aW9uPSJzYXZlZCIgc3RFdnQ6aW5zdGFuY2VJRD0ieG1wLmlpZDo2YTQ4Y2ZmZS1iZjkyLWU5NGUtOWU1NC03YTk0ZjE4ZmM2ZTQiIHN0RXZ0OndoZW49IjIwMjMtMTEtMjVUMTc6MjQ6MzErMDg6MDAiIHN0RXZ0OnNvZnR3YXJlQWdlbnQ9IkFkb2JlIFBob3Rvc2hvcCAyMi41IChXaW5kb3dzKSIgc3RFdnQ6Y2hhbmdlZD0iLyIvPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0ic2F2ZWQiIHN0RXZ0Omluc3RhbmNlSUQ9InhtcC5paWQ6NmY3MzBhMjgtNDk2NS1jNTQyLTllNzEtOTBiODc1OWYwOWI2IiBzdEV2dDp3aGVuPSIyMDIzLTExLTI4VDA5OjEwOjEyKzA4OjAwIiBzdEV2dDpzb2Z0d2FyZUFnZW50PSJBZG9iZSBQaG90b3Nob3AgMjIuNSAoV2luZG93cykiIHN0RXZ0OmNoYW5nZWQ9Ii8iLz4gPC9yZGY6U2VxPiA8L3htcE1NOkhpc3Rvcnk+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+/2R4ggAAMvBJREFUeJzt3XmUpndd5v93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","option":{"tooltip":{"show":false},"backgroundColor":"transparent","series":[{"sizeRange":[9,32],"layoutAnimation":true,"shape":"circle","data":[{"name":"花鸟市场","value":1446},{"name":"汽车","value":928},{"name":"视频","value":906},{"name":"电视","value":825},{"name":"Lover Boy 88","value":514},{"name":"动漫","value":486},{"name":"音乐","value":53},{"name":"直播","value":163},{"name":"广播电台","value":86},{"name":"戏曲曲艺","value":17},{"name":"演出票务","value":6},{"name":"给陌生的你听","value":1},{"name":"资讯","value":1437},{"name":"商业财经","value":422},{"name":"娱乐八卦","value":353},{"name":"军事","value":331},{"name":"科技资讯","value":313},{"name":"社会时政","value":307},{"name":"时尚","value":43},{"name":"网络奇闻","value":15},{"name":"旅游出行","value":438},{"name":"景点类型","value":957},{"name":"国内游","value":927},{"name":"远途出行方式","value":908},{"name":"酒店","value":693},{"name":"关注景点","value":611},{"name":"旅游网站偏好","value":512},{"name":"出国游","value":382},{"name":"交通票务","value":312},{"name":"旅游方式","value":187},{"name":"旅游主题","value":163},{"name":"港澳台","value":104},{"name":"本地周边游","value":3},{"name":"小卖家","value":1331},{"name":"全日制学校","value":941},{"name":"基础教育科目","value":585},{"name":"考试培训","value":473},{"name":"语言学习","value":358},{"name":"留学","value":246},{"name":"K12课程培训","value":207},{"name":"艺术培训","value":194},{"name":"技能培训","value":104},{"name":"IT培训","value":87},{"name":"高等教育专业","value":63},{"name":"家教","value":48},{"name":"体育培训","value":23},{"name":"职场培训","value":5},{"name":"金融财经","value":1328},{"name":"银行","value":765},{"name":"股票","value":452},{"name":"保险","value":415},{"name":"贷款","value":253},{"name":"基金","value":211},{"name":"信用卡","value":180},{"name":"外汇","value":138},{"name":"P2P","value":116},{"name":"贵金属","value":98},{"name":"债券","value":93},{"name":"网络理财","value":92},{"name":"信托","value":90},{"name":"征信","value":76},{"name":"期货","value":76},{"name":"公积金","value":40},{"name":"银行理财","value":36},{"name":"银行业务","value":30},{"name":"典当","value":7},{"name":"海外置业","value":1},{"name":"汽车","value":1309},{"name":"汽车档次","value":965},{"name":"汽车品牌","value":900},{"name":"汽车车型","value":727},{"name":"购车阶段","value":461},{"name":"二手车","value":309},{"name":"汽车美容","value":260},{"name":"新能源汽车","value":173},{"name":"汽车维修","value":155},{"name":"租车服务","value":136},{"name":"车展","value":121},{"name":"违章查询","value":76},{"name":"汽车改装","value":62},{"name":"汽车用品","value":37},{"name":"路况查询","value":32},{"name":"汽车保险","value":28},{"name":"陪驾代驾","value":4},{"name":"网络购物","value":1275},{"name":"做我的猫","value":1088},{"name":"只想要你知道","value":907},{"name":"团购","value":837},{"name":"比价","value":201},{"name":"海淘","value":195},{"name":"移动APP购物","value":179},{"name":"支付方式","value":119},{"name":"代购","value":43},{"name":"体育健身","value":1234},{"name":"体育赛事项目","value":802},{"name":"运动项目","value":405},{"name":"体育类赛事","value":337},{"name":"健身项目","value":199},{"name":"健身房健身","value":78},{"name":"运动健身","value":77},{"name":"家庭健身","value":36},{"name":"健身器械","value":29},{"name":"办公室健身","value":3},{"name":"商务服务","value":1201},{"name":"法律咨询","value":508},{"name":"化工材料","value":147},{"name":"广告服务","value":125},{"name":"会计审计","value":115},{"name":"人员招聘","value":101},{"name":"印刷打印","value":66},{"name":"知识产权","value":32},{"name":"翻译","value":22},{"name":"安全安保","value":9},{"name":"公关服务","value":8},{"name":"商旅服务","value":2},{"name":"展会服务","value":2},{"name":"特许经营","value":1},{"name":"休闲爱好","value":1169},{"name":"收藏","value":412},{"name":"摄影","value":393},{"name":"温泉","value":230},{"name":"博彩彩票","value":211},{"name":"美术","value":207},{"name":"书法","value":139},{"name":"DIY手工","value":75},{"name":"舞蹈","value":23},{"name":"钓鱼","value":21},{"name":"棋牌桌游","value":17},{"name":"KTV","value":6},{"name":"密室","value":5},{"name":"采摘","value":4},{"name":"电玩","value":1},{"name":"真人CS","value":1},{"name":"轰趴","value":1},{"name":"家电数码","value":1111},{"name":"手机","value":885},{"name":"电脑","value":543},{"name":"大家电","value":321},{"name":"家电关注品牌","value":253},{"name":"网络设备","value":162},{"name":"摄影器材","value":149},{"name":"影音设备","value":133},{"name":"办公数码设备","value":113},{"name":"生活电器","value":67},{"name":"厨房电器","value":54},{"name":"智能设备","value":45},{"name":"个人护理电器","value":22},{"name":"服饰鞋包","value":1047},{"name":"服装","value":566},{"name":"饰品","value":289},{"name":"鞋","value":184},{"name":"箱包","value":168},{"name":"奢侈品","value":137},{"name":"母婴亲子","value":1041},{"name":"孕婴保健","value":505},{"name":"母婴社区","value":299},{"name":"早教","value":103},{"name":"奶粉辅食","value":66},{"name":"童车童床","value":41},{"name":"关注品牌","value":271},{"name":"宝宝玩乐","value":30},{"name":"母婴护理服务","value":25},{"name":"纸尿裤湿巾","value":16},{"name":"妈妈用品","value":15},{"name":"宝宝起名","value":12},{"name":"童装童鞋","value":9},{"name":"胎教","value":8},{"name":"宝宝安全","value":1},{"name":"宝宝洗护用品","value":1},{"name":"软件应用","value":1018},{"name":"系统工具","value":896},{"name":"理财购物","value":440},{"name":"生活实用","value":365},{"name":"影音图像","value":256},{"name":"社交通讯","value":214},{"name":"手机美化","value":39},{"name":"办公学习","value":28},{"name":"应用市场","value":23},{"name":"母婴育儿","value":14},{"name":"游戏","value":946},{"name":"手机游戏","value":565},{"name":"PC游戏","value":353},{"name":"网页游戏","value":254},{"name":"游戏机","value":188},{"name":"模拟辅助","value":166},{"name":"个护美容","value":942},{"name":"护肤品","value":177},{"name":"彩妆","value":133},{"name":"美发","value":80},{"name":"香水","value":50},{"name":"个人护理","value":46},{"name":"美甲","value":26},{"name":"SPA美体","value":21},{"name":"花鸟萌宠","value":914},{"name":"绿植花卉","value":311},{"name":"狗","value":257},{"name":"其他宠物","value":131},{"name":"水族","value":125},{"name":"猫","value":122},{"name":"动物","value":81},{"name":"鸟","value":67},{"name":"宠物用品","value":41},{"name":"宠物服务","value":26},{"name":"书籍阅读","value":913},{"name":"网络小说","value":483},{"name":"关注书籍","value":128},{"name":"文学","value":105},{"name":"报刊杂志","value":77},{"name":"人文社科","value":22},{"name":"建材家居","value":907},{"name":"装修建材","value":644},{"name":"家具","value":273},{"name":"家居风格","value":187},{"name":"家居家装关注品牌","value":140},{"name":"家纺","value":107},{"name":"厨具","value":47},{"name":"灯具","value":43},{"name":"家居饰品","value":29},{"name":"家居日常用品","value":10},{"name":"生活服务","value":883},{"name":"物流配送","value":536},{"name":"家政服务","value":108},{"name":"摄影服务","value":49},{"name":"搬家服务","value":38},{"name":"物业维修","value":37},{"name":"婚庆服务","value":24},{"name":"二手回收","value":24},{"name":"鲜花配送","value":3},{"name":"维修服务","value":3},{"name":"殡葬服务","value":1},{"name":"求职创业","value":874},{"name":"创业","value":363},{"name":"目标职位","value":162},{"name":"目标行业","value":50},{"name":"兼职","value":21},{"name":"期望年薪","value":20},{"name":"实习","value":16},{"name":"雇主类型","value":10},{"name":"星座运势","value":789},{"name":"星座","value":316},{"name":"算命","value":303},{"name":"解梦","value":196},{"name":"风水","value":93},{"name":"面相分析","value":47},{"name":"手相","value":32},{"name":"公益","value":90}],"keepAspect":false,"type":"wordCloud","rotationRange":[-90,90],"gridSize":8,"shrinkToFit":false,"top":"center","left":"center","width":"80%","emphasis":{"focus":"self","textStyle":{"textShadowColor":"#333","textShadowBlur":4}},"drawOutOfBound":false,"rotationStep":45,"textStyle":{"color":"function(){return\"rgb(\"+[Math.round(Math.floor(Math.random() * (100 - 255)) + 255),Math.round(Math.floor(Math.random() * (100 - 255)) + 255),Math.round(Math.floor(Math.random() * (100 - 255)) + 255)].join(\",\")+\")\"}","fontWeight":500,"fontFamily":"sans-serif"},"height":"80%","maskImage":{}}]}}
				wordcloud = JSON.parse(JSON.stringify(wordcloud), (k, v) => {
					if(typeof v == 'string' && v.indexOf('function') > -1){
						return eval("(function(){return "+v+" })()")
					}
					return v;
				})
				wordcloud.option.series[0].data=wordcloudData;
				
				this.myChart0 = echarts.init(document.getElementById(echartsId));
				let myChart = this.myChart0
				let img = wordcloud.maskImage
			
				if (img) {
					var maskImage = new Image();
					maskImage.src = img
					maskImage.onload = function() {
						wordcloud.option.series[0].maskImage = maskImage
						myChart.clear()
						myChart.setOption(wordcloud.option)
					}
				} else {
					delete wordcloud.option.series[0].maskImage
					myChart.clear()
					myChart.setOption(wordcloud.option)
				}
			},
			getTimeStrToDay(game_over_timestamp) {
				if (game_over_timestamp == 0)
					return "";
				var date = new Date(parseInt(game_over_timestamp));
				var now = new Date();
				var hours = date.getHours() >= 10 ? date.getHours().toString() : "0" + date.getHours();
				var minutes = date.getMinutes() >= 10 ? date.getMinutes().toString() : "0" + date.getMinutes();
				var seconds = date.getSeconds() >= 10 ? date.getSeconds().toString() : "0" + date.getSeconds();
				let arr = ["日", "一", "二", "三", "四", "五", "六"];
				let d = arr[date.getDay()]
				return date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + '日' + ' ' + ' ' + '星期' + d  + ' ' + "  " + hours + ":" + minutes + ":" + seconds
			},
			times() {
				setInterval(()=>{
					let date = new Date().getTime()
					this.dates = this.getTimeStrToDay(date)
				}, 1000)
			},
			filterTime(time) {
				const date = new Date(time)
				const Y = date.getFullYear()
				const M = date.getMonth() + 1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1 
				const D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
			  
				const H = date.getHours() < 10 ? '0' + date.getHours() : date.getHours() // 小时
				const I = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes() // 分钟
				const S = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds() // 秒
			  
				return `${Y}-${M}-${D} ${H}:${I}:${S}`
			},
			init(){
				if(this.$storage.get('Token')){
					this.$http({
						url: `${this.$storage.get('sessionTable')}/session`,
						method: "get"
					}).then(({ data }) => {
						if (data && data.code != 0) {
						router.push({ name: 'login' })
						}
					});
				}else{
					router.push({ name: 'login' })
				}
			},
			geteshianyycfCount() {
				this.$http({
					url: `eshianyycf/count`,
					method: "get"
				}).then(({
					data
				}) => {
					if (data && data.code == 0) {
						this.eshianyycfCount = data.data
					}
				})
			},
			//统计接口1
			eshianyycfChat1() {
				this.$nextTick(()=>{

					this.$http({
						url: "group/eshianyycf/cname",
						method: "get",
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								xAxis.push(res[i].cname);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].cname
								})
							}
							var option = {};
							this.wordclouds(pArray,'eshianyycfChart1');
				

						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			//统计接口2
			eshianyycfChat2() {
				this.$nextTick(()=>{

					var eshianyycfChart2 = echarts.init(document.getElementById("eshianyycfChart2"),'macarons');
					this.$http({
						url: "eshianyycf/group/spfenlei",
						method: "get",
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.pieNum){
									break;
								}
								xAxis.push(res[i].spfenlei);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].spfenlei
								})
							}
							var option = {};
							let titleObj = this.pie.title
							titleObj.text = '食物类型分布'
							
							const legendObj = this.pie.legend
							
							let seriesObj = {
								type: 'pie',
								radius: '55%',
								center: ['50%', '60%'],
								data: pArray,
								emphasis: {
									itemStyle: {
										shadowBlur: 10,
										shadowOffsetX: 0,
										shadowColor: 'rgba(0, 0, 0, 0.5)'
									}
								}
							}
							seriesObj = Object.assign(seriesObj , this.pie.series)
							const gridObj = this.pie.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c} ({d}%)'
							}
							tooltipObj = Object.assign(tooltipObj , this.pie.tooltip?this.pie.tooltip:{})
							option = {
								backgroundColor: this.pie.backgroundColor,
								color: this.pie.color,
								title: titleObj,
								legend: legendObj,
								grid: gridObj,
								tooltip: tooltipObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							eshianyycfChart2.setOption(option);
				

							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								eshianyycfChart2.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			//统计接口3
			eshianyycfChat3() {
				this.$nextTick(()=>{

					var eshianyycfChart3 = echarts.init(document.getElementById("eshianyycfChart3"),'macarons');
					this.$http({
						url: "eshianyycf/group/chandi",
						method: "get",
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.barNum){
									break;
								}
								xAxis.push(res[i].chandi);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].chandi
								})
							}
							var option = {};
							let titleObj = this.bar.title
							titleObj.text = '产地分布'
							
							const legendObj = this.bar.legend
							
							let xAxisObj = this.bar.xAxis
							xAxisObj.type = 'category'
							xAxisObj.data = xAxis
							
							
							let yAxisObj = this.bar.yAxis
							yAxisObj.type = 'value'
							
							let seriesObj = {
								data: yAxis,
								type: 'bar'
							}
							seriesObj = Object.assign(seriesObj , this.bar.series)
							const gridObj = this.bar.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c}'
							}
							tooltipObj = Object.assign(tooltipObj , this.bar.tooltip?this.bar.tooltip:{})
							option = {
								backgroundColor: this.bar.backgroundColor,
								color: this.bar.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								xAxis: xAxisObj,
								yAxis: yAxisObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							eshianyycfChart3.setOption(option);
				
							this.myChartInterval(1, option.xAxis.data, option.series[0].data, eshianyycfChart3)

							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								eshianyycfChart3.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			//统计接口4
			eshianyycfChat4() {
				this.$nextTick(()=>{

					var eshianyycfChart4 = echarts.init(document.getElementById("eshianyycfChart4"),'macarons');
					this.$http({
						url: "eshianyycf/sectionStat/nengliang",
						method: "get",
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.pieNum){
									break;
								}
								xAxis.push(res[i].nengliang);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].nengliang
								})
							}
							var option = {};
							let titleObj = this.pie2?this.pie2.title:this.pie.title
							titleObj.text = '能量区间'
							
							const legendObj = this.pie2.legend
							
							let seriesObj = {
								type: 'pie',
								radius: ['25%', '55%'],
								center: ['50%', '60%'],
								data: pArray,
								emphasis: {
									itemStyle: {
										shadowBlur: 10,
										shadowOffsetX: 0,
										shadowColor: 'rgba(0, 0, 0, 0.5)'
									}
								}
							}
							seriesObj = Object.assign(seriesObj , this.pie2.series)
							const gridObj = this.pie2.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c} ({d}%)'
							}
							tooltipObj = Object.assign(tooltipObj , this.pie2.tooltip?this.pie2.tooltip:{})
							option = {
								backgroundColor: this.pie2.backgroundColor,
								color: this.pie2.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							eshianyycfChart4.setOption(option);
				

							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								eshianyycfChart4.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			//统计接口5
			eshianyycfChat5() {
				this.$nextTick(()=>{

					var eshianyycfChart5 = echarts.init(document.getElementById("eshianyycfChart5"),'macarons');
					this.$http({
						url: `eshianyycf/value/cname/danbaizhi`,
						method: "get",
						params: {
							order: 'desc'
						}
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.barNum){
									break;
								}
								xAxis.push(res[i].cname);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].cname
								})
							}
							var option = {};
							let titleObj = this.bar2.title
							titleObj.text = '蛋白质排名'
							
							const legendObj = this.bar2.legend
							
							let xAxisObj = this.bar2.xAxis
							xAxisObj.type = 'value'
							
							
							let yAxisObj = this.bar2.yAxis
							yAxisObj.type = 'category'
							yAxisObj.data = xAxis
							let seriesObj = {
								data: yAxis,
								type: 'bar'
							}
							seriesObj = Object.assign(seriesObj , this.bar2.series)
							const gridObj = this.bar2.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c}'
							}
							tooltipObj = Object.assign(tooltipObj , this.bar2.tooltip?this.bar2.tooltip:{})
							option = {
								backgroundColor: this.bar2.backgroundColor,
								color: this.bar2.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								xAxis: xAxisObj,
								yAxis: yAxisObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							eshianyycfChart5.setOption(option);

							this.myChartInterval(2, option.yAxis.data, option.series[0].data, eshianyycfChart5)

							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								eshianyycfChart5.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			// 统计接口6
			eshianyycfChat6() {
				this.$nextTick(()=>{

					var eshianyycfChart6 = echarts.init(document.getElementById("eshianyycfChart6"),'macarons');
					this.$http({
						url: `eshianyycf/value/cname/tshhw`,
						method: "get",
						params: {
							order: 'desc'
						}
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.lineNum){
									break;
								}
								xAxis.push(res[i].cname);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].cname
								})
							}
							var option = {};
							let titleObj = this.line.title
							titleObj.text = '碳水化合物排名'
							
							const legendObj = this.line.legend
							
							let xAxisObj = this.line.xAxis
							xAxisObj.type = 'category'
							xAxisObj.boundaryGap = false
							xAxisObj.data = xAxis
							
							
							let yAxisObj = this.line.yAxis
							yAxisObj.type = 'value'
							
							let seriesObj = {
								data: yAxis,
								type: 'line',
							}
							seriesObj = Object.assign(seriesObj , this.line.series)
							const gridObj = this.line.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c}'
							}
							tooltipObj = Object.assign(tooltipObj , this.line.tooltip?this.line.tooltip:{})
							option = {
								backgroundColor: this.line.backgroundColor,
								color: this.line.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								xAxis: xAxisObj,
								yAxis: yAxisObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							eshianyycfChart6.setOption(option);


							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								eshianyycfChart6.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
		}
	};
</script>
<style lang="scss" scoped>
	// table
	.el-table:before{
		display: none;
	}
	.el-table:after{
		display: none;
	}
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #fff;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 6px 0;
				background: none;
				border-color: rgba(92,135,230,.3);
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 6px 0;
				color: #fff;
				background: none;
				border-color: rgba(92,135,230,.3);
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
	
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 6px 0;
				color: #fff;
				background: none;
				border-color: rgba(92,135,230,.3);
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 6px 0;
				color: #fff;
				background: none;
				border-color: rgba(92,135,230,.3);
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	.echarts1 {
				padding: 10px 0 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: 1 1 auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
			}
	.echarts1:hover {
			}
	.echarts2 {
				padding: 0 0 0 60px;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
			}
	.echarts2:hover {
			}
	.echarts3 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
			}
	.echarts3:hover {
			}
	.echarts4 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
			}
	.echarts4:hover {
			}
	.echarts5 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
			}
	.echarts5:hover {
			}
	.echarts6 {
				padding: 0 0 0 90px;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
			}
	.echarts6:hover {
			}
	.echarts7 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
				order: 5;
			}
	.echarts7:hover {
			}
	#particles{
		background-repeat: no-repeat;
		z-index: 1;
		background-size: cover;
		width: 100%;
		position: absolute;
		background-position: 50% 50%;
		height: 100%;
	}
	::-webkit-scrollbar {
		display: none; /* 针对Webkit浏览器 */
	}
</style>

