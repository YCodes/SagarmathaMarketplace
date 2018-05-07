<%@ include file="header.jsp"%>


 <div id="header_bottom">
	        	<p>
	            	<a href="<c:url value='/admin/addCategory'/>">Add Product Category</a> | 
	            	<a href="<c:url value='/admin/addAdmin'/>">Add Admin</a>
	            </p>
	            
	        </div> <!-- END of header bottom -->
	    </div> <!-- END of header -->


<div id="tooplate_main">
	<span class="main_border main_border_t"></span><span
		class="main_border main_border_b"></span>

	<div class="container">

		<div class="col col_1">
			<h1>Add Product Category</h1>
		</div>
		<div class="col col_1">
			<form:form role="form" action="addProductCategory" method="POST"
				modelAttribute="category">
				<div class="form-group">
					<label>Category Name</label><input type="text" class="form-control"
						name="categoryName" id="addCategory" style="width: 300px;">
					<label>Description</label>
					<textarea rows="4" class="form-control" name="categoryDescription"
						id="description" style="width: 300px;"></textarea>
				</div>
				<br />
				<input type="submit" value="Submit" class="btn btn-info" />

			</form:form>
		</div>

	</div>

	<div class="clear"></div>
</div>
<!-- END of main -->


<%@ include file="footer.jsp"%>