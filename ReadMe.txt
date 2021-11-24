I divided the project into three main packages : InforP as the main, Services for the JSON manipulation 
and  ProductServieImpl for the implementation of the logic behind the different features of the minimap.
ProductServieImpl contains result : the class calculating the total forecast at the end.
			   compareDate : Used to compare the date of the current transaction and the dates of the available promos for that certain product.
		           fetchPromo : Used to find the possible promos for a certain product at a certain store.
                           fetchProduct : Used to get the product that we are trying to buy/sell and to find possible promotions for it.
                           getPromoById : Used to get promostions by Id.
Service Contains the different services used to GET POST the different JSONs through URLs.	



	 
