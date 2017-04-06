<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<jsp:include page="./common/head_easyui.jsp"></jsp:include>
<script type="text/javascript">
	function showCenter(url){
		$('#centerIframe').attr('src',url);
	}
</script>
<style type="text/css">
	table tr{
		height:30px;
	}
	table tr td a{
		font-size:14px;
	}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<!-- <div data-options="region:'north'" style="height: 100px"></div> -->
		<div data-options="region:'south',split:true" style="height: 50px;"></div>
		<div data-options="region:'west',split:true" title="功能菜单" style="width: 300px;">
			<div class="easyui-panel"
				data-options="title:'功能导航',border:false,fit:true">
				<div class="easyui-accordion" data-options="fit:true,border:false">
					<div title="系统菜单" data-options="iconCls:'icon-save'">
						<table>
							<tr><td><a href="javascript:void(0);" onclick="showCenter('${path}/areaController/showAreaInfoByIp2');">Test showAreaInfoByIp2</a></td></tr>
							<tr><td><a href="javascript:void(0);" onclick="showCenter('${path}/areaController/showAreaInfoByIp');">Test showAreaInfoByIp</a></td></tr>
							<tr><td><a href="javascript:void(0);" onclick="showCenter('${path}/areaController/readAreaXmlFile');">Test readAreaXmlFile</a></td></tr>
							<tr><td><a href="javascript:void(0);" onclick="showCenter('${path}/userController/963/saveUser');">Test saveUser</a></td></tr>
							<tr><td><a href="javascript:void(0);" onclick="showCenter('${path}/userController/getAll');">Test getAll</a></td></tr>
							<tr><td><a href="javascript:void(0);" onclick="showCenter('${path}/userController/1/showUser');">Test showUser</a></td></tr>
						</table>
					
					</div>
				</div>
			</div>
		</div>
		<div data-options="region:'center',title:'内容信息'">
			<iframe id="centerIframe" style="width:800px;height:500px;" src=""></iframe>
		</div>
	</div>

</body>
</html>