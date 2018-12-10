package unitbv.util;

public class ExcelLine {

    private String elementChecked;
    private String expectedString;
    private String jspUrl;
    private String xpath;
    
    //new xls
    private String guid_interne;
    private String guid_externe;
	private String civilite;
    private String nom;
    private String prenom;
    private String identifiant;
    private String identifiant_dauchez;
    
    public ExcelLine() {
	super();
    }

    public String getElementChecked() {
	return elementChecked;
    }

    public void setElementChecked(String elementChecked) {
	this.elementChecked = elementChecked;
    }

    public String getExpectedString() {
	return expectedString;
    }

    public void setExpectedString(String expectedString) {
	this.expectedString = expectedString;
    }

    public String getJspUrl() {
	return jspUrl;
    }

    public void setJspUrl(String jspUrl) {
	this.jspUrl = jspUrl;
    }

    public String getXpath() {
	return xpath;
    }

    public void setXpath(String xpath) {
	this.xpath = xpath;
    }
    
    
    
    //new excel component for dauchez_user
    
    public String getGuid_interne(){
    	return guid_interne;
    }
    
    public void setGuid_interne(String guid_interne) {
		this.guid_interne = guid_interne;
	}
    

	public String getGuid_externe() {
		return guid_externe;
	}

	public void setGuid_externe(String guid_externe) {
		this.guid_externe = guid_externe;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getIdentifiant_dauchez() {
		return identifiant_dauchez;
	}

	public void setIdentifiant_dauchez(String identifiant_dauchez) {
		this.identifiant_dauchez = identifiant_dauchez;
	}
    

}
