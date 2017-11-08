<!doctype html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <style type="text/css">
        body,html,#container{
            height: 100%;
            margin: 0px;
        }
    </style>
    <title>快速入门</title>
</head>
<body>
<div id="container" tabindex="0"></div>
<div id="panel"></div>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.0&key=88eb604f9dfc37f75874f3fd9e52f127"></script>
<script type="text/javascript">
    var map = new AMap.Map('container',{
        resizeEnable: true,
        zoom: 16,
        center: [108.892314,34.190729]
    });
//    var startMarker = new AMap.Marker({
//        position: [108.892314,34.190729],//marker所在的位置
//        map:map,//创建时直接赋予map属性
//        content:'起点'
//    });
//    var endMarker = new AMap.Marker({
//        position: [108.945525,34.380802],//marker所在的位置
//        map:map,//创建时直接赋予map属性
//        content:'终点'
//    });
//    //也可以在创建完成后通过setMap方法执行地图对象
//    startMarker.setMap(map);
//    endMarker.setMap(map);

    AMap.plugin(['AMap.Driving'],function(){
        //创建并添加工具条控件
        var driver = new AMap.Driving({
            policy: AMap.DrivingPolicy.LEAST_DISTANCE,
            map:map,
            extensions:'all'
        });
        driver.search(
            new AMap.LngLat(108.892314,34.190729),
            new AMap.LngLat(108.945525,34.380802),
            function(status,result){
                console.info(result);
            }
        );
//        driver.search([
//                {keyword: '雁塔区唐延南路i都会1号楼二单元',city:'西安'},
//                {keyword: '西安北站',city:'西安'}],function(status,result){
//            console.info(result);
//        });
    });

</script>
</body>
</html>