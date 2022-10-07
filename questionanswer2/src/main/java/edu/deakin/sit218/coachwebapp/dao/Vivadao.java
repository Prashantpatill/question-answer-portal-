/**
 * 
 */
package edu.deakin.sit218.coachwebapp.dao;

import javax.validation.Valid;

import edu.deakin.sit218.coachwebapp.entity.Client;

/**
 * @author prash
 *
 */
public interface Vivadao {
 public void insertData (Client client);
 public Client retreiveData(Client client);
 //public void returnDistinct (Client client);

//public boolean existsClient(Client client);
 
}
