$( document ).ready(function() {
    width           = 80;
    height          = 180;
    maxTemp         = $('#temp').attr('max');
    minTemp         = $('#temp').attr('min');
    currentTemp     = $('#temp').val();                    
    bottomY         = height - 5;
    topY            = 5;
    bulbRadius      = 20;
    tubeWidth       = 21.5;
    tubeBorderWidth = 11;
    mercuryColor    = "white";
    innerBulbColor  = "#0F7DAA";
    tubeBorderColor = "#0097BB";                    
    bulb_cy         = bottomY - bulbRadius;
    bulb_cx         = width/2;
    top_cy          = topY + tubeWidth/2;                    
    tubeFill_bottom = bulb_cy;
    step            = 1;

    // Determine a suitable range of the temperature scale
        domain = [
        step * Math.floor(minTemp / step),
        step * Math.ceil(maxTemp / step)
        ];

    // D3 scale object
    scale = d3.scaleLinear()
            .range([bulb_cy - bulbRadius/2 - 8.5, top_cy])
            .domain(domain);
    tubeFill_top    = scale(currentTemp);                    
    svg             = d3.select("#thermo")
                        .append("svg")
                        .attr("width", width)
                        .attr("height", height);
    
    
    defs = svg.append("defs");

    drawThermometer();

    $('body').on('input','#temp',function(){
        
        currentTemp = $(this).val();
        var inputValue = (currentTemp - minTemp)/(maxTemp - minTemp);
        $(this).css('background-image','-webkit-gradient(linear,left top,right top,color-stop(' + inputValue + ', blue),color-stop(' + inputValue + ', red))');
        updateFields($('#temp2'),currentTemp);
    });
    $('body').on('input','#temp2',function(){
        currentTemp = $(this).val();
        updateFields($('#temp'),currentTemp);
    });
});

function updateFields(input,temp){

if (parseFloat(temp)>=parseFloat(minTemp)&& parseFloat(temp)<=parseFloat(maxTemp)) {
 $('#warning').hide();
tubeFill_top    = scale(temp); 
input.val(temp);
     
drawTemp(svg,width,tubeWidth,tubeFill_top,tubeFill_bottom,mercuryColor,bulbRadius,bulb_cx,bulb_cy);
} else {
$('#warning').show();
}
}
    function drawThermometer(){
        

        
        
        
        
        // Circle element for rounded tube top
        svg.append("circle")
        .attr("r", tubeWidth/2)
        .attr("cx", width/2)
        .attr("cy", top_cy)
        .style("fill", tubeBorderColor)
        .style("stroke", tubeBorderColor)
        .style("stroke-width", tubeBorderWidth + "px");               

        
        
        
        // Main bulb of thermometer (empty), white fill
        svg.append("circle")
        .attr("r", bulbRadius)
        .attr("cx", bulb_cx)
        .attr("cy", bulb_cy)
        .style("fill", tubeBorderColor)
        .style("stroke", tubeBorderColor)
        .style("stroke-width", tubeBorderWidth + "px");
      
       // empty mercury rounded top
       svg.append("circle")
        .attr("r",tubeWidth/2 -5.5 )
        .attr("cx",width/2)
        .attr("cy", top_cy)
        .style("fill", innerBulbColor);

        // Rect element for tube fill colour
        svg.append("rect")
        .attr("x", width/2 - (tubeWidth - tubeBorderWidth)/2)
        .attr("y", top_cy)
        .attr("height", bulb_cy - top_cy)
        .attr("width", tubeWidth - tubeBorderWidth)
        .style("shape-rendering", "crispEdges")
        .style("fill", innerBulbColor)
        .style("stroke", "none");

       



         drawTemp(svg,width,tubeWidth,tubeFill_top,tubeFill_bottom,mercuryColor,bulbRadius,bulb_cx,bulb_cy);
       
    }
    
    function drawTemp(svg,width,tubeWidth,tubeFill_top,tubeFill_bottom,mercuryColor,bulbRadius,bulb_cx,bulb_cy){
        //first we remove actual mesure
        svg.select("#top").remove();
        svg.select("#mesure").remove();
        svg.select("#rond").remove();

        // mercury top rounded
       svg.append("circle")
        .attr("id", "top")
        .attr("r",tubeWidth/2 -5.5 )
        .attr("cx",width/2)
        .attr("cy", tubeFill_top)
        .style("fill", mercuryColor);

        // Rect element for the mercury column
        svg.append("rect")
        .attr("id","mesure")
        .attr("x",  width/2 - tubeWidth/4 )
        .attr("y", tubeFill_top)
        .attr("width", tubeWidth/2)
        .attr("height", tubeFill_bottom - tubeFill_top)
        .style("shape-rendering", "crispEdges")
        .style("fill", mercuryColor);


        // left border
        svg.append("rect")
        .attr("x", (width/2) - (tubeWidth/2) - (tubeBorderWidth/2))
        .attr("y", top_cy)
        .attr("height", bulb_cy - top_cy)
        .attr("width", tubeBorderWidth)
        .style("shape-rendering", "crispEdges")
        .style("fill", tubeBorderColor);

        // right  border
        svg.append("rect")
        .attr("x", width/2 - (tubeWidth - tubeBorderWidth)/2 + (tubeWidth - tubeBorderWidth) )
        .attr("y", top_cy)
        .attr("height", bulb_cy - top_cy)
        .attr("width", tubeBorderWidth)
        .style("shape-rendering", "crispEdges")
        .style("fill", tubeBorderColor);
        
        // Main thermometer bulb fill
        svg.append("circle")
        .attr("id","rond")
        .attr("r", bulbRadius - 6)
        .attr("cx", bulb_cx)
        .attr("cy", bulb_cy)
        .style("fill", mercuryColor)
        .style("stroke", mercuryColor)
        .style("stroke-width", "2px");
    }