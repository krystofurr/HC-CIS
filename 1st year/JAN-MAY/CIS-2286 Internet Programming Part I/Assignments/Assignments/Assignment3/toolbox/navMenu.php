<!--

################## CIS-2286 Internet Programming Part I PWC ##################
	 Author: Christopher Sigouin
	 Date: February 7, 2015
	 Purpose: Assignment 3
	 Dependencies:  None 
	
-->
<?php $page = "" ?>

<div class="navMenu">
	<ul>
		<li><a href="orderVegetables.php" class="<?php if($page ==  "order") {echo "current";} ?>">
			ORDER VEGETABLES
			</a>
		</li>
		<li><a href="viewOrders.php" class="<?php if($page ==  "view") {echo "current";} ?>">
			VIEW ALL ORDERS
			</a>
		</li>
		<li><a href="resetOrders.php" class="<?php if($page ==  "reset") {echo "current";} ?>">
			RESET ORDERS
			</a>
		</li>
	</ul>
</div>


