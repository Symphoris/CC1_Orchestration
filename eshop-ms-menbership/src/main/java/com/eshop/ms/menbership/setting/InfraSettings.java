package com.eshop.ms.menbership.setting;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;

public class InfraSettings {
public static KeyPair keyPairLoader() {
		
		try (FileInputStream in = new FileInputStream("C://Users//etudiant//Documents//ING2//responsabilite_ing//Symphoris//Orchestration de service de données//eshop-ms-menbership//src//main//resources\\cle\\server.p12")){
			
				KeyStore kstore = KeyStore.getInstance("PKCS12");
				kstore.load(in,"episen".toCharArray());
				
				Key key = kstore.getKey("episen","episen".toCharArray());
				
				Certificate certificat = kstore.getCertificate("episen");
				return new KeyPair(certificat.getPublicKey(), (PrivateKey)key);
	} catch(Exception e){
		throw new RuntimeException(e);
	}
}

}
