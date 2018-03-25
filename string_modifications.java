
// Test if the string "str" is in the string "txt"
int is_in(const char *str, const char *txt){
  int i = 0;
  int str_i = 0;
  while (txt[i] != 0){
    if (txt[i] == str[str_i]){
      str_i++;
      if (str[str_i] == 0)
	return 1;
    }
    else
      str_i = 0;
    i++;
  }
  return 0;
}

//Transforme tous les caracteres speciaux en caracteres non-speciaux
void non_utf8(char *txt){
    int i = 0;
    while (txt[i] != 0){
	if ((txt[i] == "é") || (txt[i] == "è") || (txt[i] == "ê") || (txt[i] == "ë"))
	    txt[i] = "e";    
	if ((txt[i] == "à") || (txt[i] == "â") || (txt[i] == "ä"))
	    txt[i] = "a";
	if (txt[i] == "ô")
	    txt[i] = "o";
	if ((txt[i] == "ù") || (txt[i] == "û"))
		txt[i] == "u";
	i++;
    }
}


//Coupe une chaine de caractere en un tableau de mots
String[] split(char *txt){
    int i = 0;
    String array[];
    char tmp[] = "";
    while (txt[i] != 0){
	if ((txt[i] != " ") && (txt[i] != ",") && (txt[i] != ";") && (txt[i] != ".") && (txt[i] != "(") && (txt[i] != ")") && (txt[i] != "?") && (txt[i] != "!") && (txt[i] != ":")){
	    tmp.add(txt[i]);
	}
	else{
	    array.add(tmp);
	    tmp = "";
	}
	i++;
    }
    return array;
}
