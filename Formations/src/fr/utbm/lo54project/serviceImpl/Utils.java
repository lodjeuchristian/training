package fr.utbm.lo54project.serviceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest; 

/**
 * Service Utilitaire
 * Permet de fournir quelques outils r�utilisables, � l'application
 * @author Lodjeu - Libam - Ntieche
 *
 */
public class Utils {
	
	/**
	 * Permet de d�crypter la chaine de caract�re id, en id r�el utilis� dans la base de donn�es
	 * @param chaine
	 * @return
	 */
	public static int decryptId(String chaine){
		return (Integer.parseInt(chaine.substring(4))/9874);
	}
	
	/**
	 * Permet de crypter l'id r�el de la base de donn�es en une chaine de caract�res 
	 * afin que l'utilisateur ne puisse pas connaitre l'id r�ellement utilis�, ceci � des fins de s�curit�
	 * @param id
	 * @return
	 */
	public static String cryptId(int id){
		return "sha1"+(id*9874);
	}
	
	/**
	 * Retourne le cookie ayant pour nom : nom
	 * @param request
	 * @param nom
	 * @return
	 */
    public static String getCookieValue( HttpServletRequest request, String nom ) {
        Cookie[] cookies = request.getCookies();
        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie != null && nom.equals( cookie.getName() ) ) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    
    
    /**
     * Convertit une date de type dd/mm/yyyy en yyyy-mm-dd connu par jpa
     */
    public static String convertToEnDate(String s){
		 return s.substring(6,10)+"-"+s.substring(3,5)+"-"+s.substring(0,2); 
    }
 

}
