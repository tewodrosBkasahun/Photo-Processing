package sysutilities;

final public class Address {
	private  String street, city, state;
	private  String zipCode;
	

	public Address() {
		this.street = "8223 Paint Branch Dr.";
		this.city = "College Park";
		this.state = "MD";
		this.zipCode = "20742";
	}

	public Address(String street) {
		this.street = street;
		this.city = "College Park";
		this.state = "MD";
		this.zipCode = "20742";
	}
	

	public Address(String street, String city, String state, String zipCode) {

	if ( street== null || city == null || state == null  || zipCode== null|| !zipValidator(zipCode)) {
			throw new IllegalArgumentException("Invalid Address Argument");
		} else {
			this.street = street.trim();
			this.city = city.trim();
			this.state = state.trim();
			this.zipCode = zipCode.trim();
		}

	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}
    
	public void copy(Address otherAd){
		this.street=otherAd.street;
		this.city=otherAd.city;
		this.state=otherAd.state;
		this.zipCode=otherAd.zipCode;
		
	}
	public boolean equals(Address anotherAdrs) {
		if (this.equals(anotherAdrs)) {
			return true;
		} else {
			return false;
		}

	}

	public String toString() {
		return street + " " + city + " " + state + " " + zipCode;
	}

	public boolean zipValidator(String zip) {
		boolean ans = true;
		String trimedZip = zip.trim();
		for (int i = 0; i < trimedZip.length(); i++) {
			if (!Character.isDigit(trimedZip.charAt(i))) {
				ans = false;
			}

		}

		return ans;
	}

	/*
	 * 
	 * The parameters are the street, city, state, and zip code. The names of
	 * the parameters must be the same names used for the corresponding instance
	 * variables. The constructor will throw an IllegalArgumentException
	 * exception with the message "Invalid Address Argument" if any parameter is
	 * null, or if the zip code has characters others than digits. Notice that
	 * any of the parameters can have spaces surrounding them (e.g., "   MD "),
	 * but you must get rid of them before using the values to initialize the
	 * object. The method Character.isDigit can help during the implementation
	 * of this method. See the Java API (Character class) for additional
	 * information.
	 * 
	 */

}