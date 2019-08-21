package filter;

public class langFilter {
    public String lang(String langs){
        String lang = langs.toUpperCase();
        String value = null;
        switch (lang){
            case "EN":
                value = "en";
                break;
            case "VI":
                value = "vi";
                break;
            case "CN":
                value = "cn";
                break;
            case "DE":
                value = "de";
                break;
            case "ES":
                value = "es";
                break;
            case "ID":
                value = "id";
                break;
            case "IT":
                value = "it";
                break;
            case "JA":
                value = "ja";
                break;
            case "TW":
                value = "tw";
                break;
            case "RU":
                value = "ru";
                break;
            case "TH":
                value = "th";
                break;
            case "FR":
                value = "fr";
                break;
            default:
                value = "ko";
                break;
        }

        return  value;
    }
}
