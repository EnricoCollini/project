package controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import dao.AmministratoreDao;
import model.Amministratore;

@Stateless
public class AmministratoreController {

	@Inject
	private AmministratoreDao amministratoredao;
		
	public List<Long> getItiAssociati(long idAmministratore){
		return amministratoredao.itinerariAssociati(idAmministratore);
	}
	
	public List<Long> getRistoAssociati(long idAmministratore){
		return amministratoredao.ristoriAssociati(idAmministratore);
	}
	
	public List<Long> getPuntiInteresseAssociati(long idAmministratore){
		return amministratoredao.puntiInteresseAssociati(idAmministratore);
	}
	
	public List<Long> getStruttureAssociate(long idAmministratore){
		return amministratoredao.struttureAssociate(idAmministratore);
	}
	
	public List<Long> getAreeAssociate(long idAmministratore){
		return amministratoredao.areeAssociate(idAmministratore);
	}
	
	public long getIdAmministratore(String emailAdmin) {
		return amministratoredao.getIdAmministratore(emailAdmin);
	}
	
	public boolean checkIfAuth(String jwt) {
		System.out.println(jwt);
		List<String> listaJWT = amministratoredao.getJwtTokens();
		if(listaJWT.contains(jwt)) {
			return true;
		}else {
			return false;
		}
	}
	
	/*public boolean validate(Amministratore amministratore) {
		Long index = amministratoredao.getIdAmministratore(amministratore.getEmail());
		if(index>0) {
			return true;
		}else {
			return false;
		}
	}*/
	public String sha1(String input) {
	    String sha1 = null;
	    try {
	        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
	        msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
	        sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
	    } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
	    	e.printStackTrace();
	    }
	    return sha1;
	}
	
	public boolean validate(Amministratore amministratore){
		String email = amministratore.getEmail();
		String passwordsha1 = amministratore.getPassword();
		
		Long index = amministratoredao.getIdAmministratore(amministratore.getEmail());
		
		if(index>0) {
			Amministratore admin = amministratoredao.getAmministratore(index);
			
	        String sha = sha1(admin.getPassword());
	        System.out.println("sha1");
	        System.out.println(sha);
			if(sha.compareToIgnoreCase(passwordsha1)==0) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}
	
	
	public void setToken(long id, String jwt) {
		Amministratore amministratore = amministratoredao.getAmministratore(id);
		amministratore.setJwt(jwt);
	}
	
}
