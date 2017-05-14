$(function () {

    $('#container').highcharts({

        chart: {
            polar: true,
            type: 'line'
        },

        title: {
            text: 'Budget vs spending',
            x: -80
        },

        pane: {
            size: '80%'
        },

        xAxis: {
            categories: ['Sales', 'Marketing', 'Development', 'Customer Support',
                    'Information Technology', 'Administration'],
            tickmarkPlacement: 'on',
            lineWidth: 0
        },

        yAxis: {
            gridLineInterpolation: 'polygon',
            lineWidth: 0,
            min: 0
        },

        tooltip: {
            shared: true,
            pointFormat: '<span style="color:{series.color}">{series.name}: <b>${point.y:,.0f}</b><br/>'
        },

        legend: {
            align: 'right',
            verticalAlign: 'top',
            y: 70,
            layout: 'vertical'
        },

        series: [{
            name: 'Allocated Budget',
            data: [43000, 19000, 60000, 35000, 17000, 10000],
            pointPlacement: 'on'
        }, {
            name: 'Actual Spending',
            data: [50000, 39000, 42000, 31000, 26000, 14000],
            pointPlacement: 'on'
        }]

    });
});
//var sb0=eval($("#inp0").val());
//var sb1=eval($("#inp1").val());
  var chart;
    $(document).ready(function () {

        chart = new Highcharts.Chart({

            chart: {
                padding:0,
                margin:0,
                renderTo: 'container',
                polar: true,
                type: 'area',
                //backgroundColor: '#F2F2F2'
                //plotBackgroundImage:"http://imgd3.laoyuegou.com/mayday/img/dota-news/bg_gray.jpg",
            },
            title: {
                text: '',
                x: -80
            },
            credits:{
                enabled: false
            },
            exporting: {
                enabled: false
            },
            pane: {
                size: '85%',
                startAngle: 20,
                center: ['50%', '50%']
            },
            plotOptions: {
                area: {
                    fillOpacity: 0.30
                }
            },

            xAxis: {
                categories: [$("#inp0").val(),$("#inp1").val(),$("#inp2").val(),$("#inp3").val()],
                tickmarkPlacement: 'on',
                lineWidth: 0,
                gridLineColor: '#D8D8D8',
                labels:{
                    style:{
                        color: '#B3B9C2',//B7F1E2
                    }
                },
                showFirstLabel:true
            },

            yAxis: {
                gridLineInterpolation: 'polygon',
                lineWidth: 0,
                min: 0,
                max: 75,
                gridLineWidth :1,
                gridLineColor: '#B3B9C2',
                plotBands: [{
                    color: '#F2F2F2',
                    borderColor:'#B3B9C2',
                    borderWidth:1,
                    from: 0,
                    to: 25
                }, {
                    color: '#F2F2F2',
                    borderColor:'#B3B9C2',
                    borderWidth:1,
                    from: 25,
                    to: 50
                }, {
                    color: '#F2F2F2',
                    borderColor:'#B3B9C2',
                    borderWidth:1,
                    from: 50,
                    to: 75
                }, {
                    color: '#F2F2F2',
                    borderColor:'#B3B9C2',
                    borderWidth:1,
                    from: 75,
                    to: 100
                }],
                labels:{
                    enabled: false
                }
            },

            tooltip: {
                useHTML: true,
                backgroundColor: '#FFFFFF',
                borderWidth: 0,
                style: {
                    color: 'gray',
                    padding: '10px'
                },
                headerFormat: '',
//                shared: true,
//                pointFormat: '<span style="color:{series.color}">{series.name}: <b>{point.y:,.0f}</b><br/>',
                // ["kdara"]=>    //输出
                // ["hdra"]=>     //团战
                // ["dra"]=>      //生存
                // ["gpmra"]=>    //发育 每分钟金钱
                // ["tdra"]=>     //推塔
                formatter: function(){
                  
                    if(this.x == $("#inp0").val())
                    {
                        return  "<p style='text-align: center;'>" + this.key + ": <span style='color:#f60'>" +  eval($("#inp4").val()) + "</span></p ></span>";
                    }
                    else if(this.x == $("#inp1").val())
                    {
                        return "<p style='text-align: center;'>" +this.key + ": <span style='color:#f60'>" +  eval($("#inp5").val())+ "</span></p ></span>";
                    }
                    else if(this.x == $("#inp2").val())
                    {
                        return "<p style='text-align: center;'>" +this.key + ": <span style='color:#f60'>" +  eval($("#inp6").val())+ "</span></p ></span>";
                    }
                    else if(this.x == $("#inp3").val())
                    {
                        return "<p style='text-align: center;'>" +this.key + ": <span style='color:#f60'>" +  eval($("#inp7").val())+ "</span></p ></span>";
                    }
//                    else if(this.x == sb0[4])
//                    {
//                        return "<p style='text-align: center;'>" +this.key + ": <span style='color:#f60'>" +  "A"+ "</span></p ></span>";
//                    }
//
//                    
                }
            },

            legend : {
              enabled: false
            },

            series: [{
                data: [{
                    name: $("#inp0").val(),
                    y: eval($("#inp4").val()),
                    marker: {
                       // symbol: 'url(http://imgd3.laoyuegou.com/static/img/app/dota2/icon_shuchu_dark.png)',
                        width: 13,
                        height: 13
                    }
                },{
                    name: $("#inp1").val(),
                    y: eval($("#inp5").val()),
                    marker: {
                      //  symbol: 'url(http://imgd3.laoyuegou.com/static/img/app/dota2/icon_shengcun_dark.png)',
                        width: 13,
                        height: 13
                    }
                },{
                    name: $("#inp2").val(),
                    y: eval($("#inp6").val()),
                    marker: {
                      //  symbol: 'url(http://imgd3.laoyuegou.com/static/img/app/dota2/icon_tuita_dark.png)',
                        width: 13,
                        height: 13
                    }
                },{
                    name: $("#inp3").val(),
                    y: eval($("#inp7").val()),
                    marker: {
                       // symbol: 'url(http://imgd3.laoyuegou.com/static/img/app/dota2/icon_tuanzhan_dark.png)',
                        width: 13,
                        height: 13
                    }
           }],
 //               ,{
//             	   name: sb0[4],
//                   y: sb1[4],
//                   marker: {
//                    //   symbol: 'url(http://imgd3.laoyuegou.com/static/img/app/dota2/icon_fayu_dark.png)',
//                       width: 13,
//                       height: 13
//                   }
//            
//            }],
                pointPlacement: 'on',
                color: '#269783'
            } ]

            });

        chart.series[0].points[0].onMouseOver();
    });
