<%@ include file = "navigation.jsp" %>
    
    <div id="tooplate_main"><span class="main_border main_border_t"></span><span class="main_border main_border_b"></span>
    
    <div id="content">
    	<h1>Items in Cart</h1>
    	
        <table width="900px" cols="0" cellspacing="0" cellpadding="5">
          <tr bgcolor="#ddd">
                <th width="220" align="left">Image </th> 
                <th width="180" align="left">Description </th> 
                <th width="100" align="center">Quantity </th> 
                <th width="60" align="right">Price </th> 
                <th width="60" align="right">Total </th> 
                <th width="90"> </th>
                
          </tr>
            <tr>
                <td><img src="resources/images/product/01.jpg" alt="image" /></td> 
                <td>Etiam in tellus</td> 
                <td align="center"><input type="text" value="1" style="width: 20px; text-align: right" /> </td>
                <td align="right">$100 </td> 
                <td align="right">$100 </td>
                <td align="center"> <a href="#"><img src="resources/images/remove.png" alt="remove" /><br />Remove</a> </td>
            </tr>
            <tr>
                <td><img src="resources/images/product/02.jpg" alt="image" /> </td>
                <td>Hendrerit justo</td> 
                <td align="center"><input type="text" value="1" style="width: 20px; text-align: right" />  </td>
                <td align="right">$40  </td>
                <td align="right">$40 </td>
                <td align="center"> <a href="#"><img src="resources/images/remove.png" alt="remove" /><br />Remove</a>  </td>
            </tr>
            <tr>
                <td colspan="3" align="right"  height="30px">Have you modified your basket? Please click here to <a href="shoppingcart.html"><strong>Update</strong></a>&nbsp;&nbsp;</td>
                <td align="right" style="font-weight:bold"> Total </td>
                <td align="right" style="font-weight:bold">$140 </td>
                <td style="font-weight:bold"> </td>
            </tr>
        </table>
        <p class="right"><a href="checkout.html" class="button">checkout</a></p>
            
        
		</div>
        
     
        <div class="clear"></div>
    </div> <!-- END of main -->
    
</div> <!-- END of wrapper -->

<%@ include file = "footer.jsp" %>