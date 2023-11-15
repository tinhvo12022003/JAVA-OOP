/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bill;

import Customer.Customer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class history_bill {
    private Customer customer;
    private int tong_mua;
    
    public history_bill(){
        this.customer = new Customer();
        this.tong_mua = 0;
    }
    
    public history_bill(Customer customer, int tong_mua, String ma_HD){
        this.customer = new Customer(customer);
        this.tong_mua = tong_mua;
    }
    
    public history_bill(history_bill hb){
        this.customer = new Customer(hb.customer);
        this.tong_mua = hb.tong_mua;
    }
    
    public void setCustomer(Customer customer){
        this.customer = new Customer(customer);
    }
    
    public Customer getCustomer(){
        return new Customer(new history_bill(this).customer);
    }
    
    public void setTongMua(int tong_mua){
        this.tong_mua = tong_mua;
    }
    
    public int getTongMua(){
        return new history_bill(this).tong_mua;
    }
    
    public ArrayList<history_bill> readFile_historyBill(){
        ArrayList<history_bill> lst_hb = new ArrayList<>();
        
        Customer customer = new Customer();
        
        ArrayList<Customer> lst_customer = new ArrayList<>(customer.readFile_Customer());
        
        try(BufferedReader br = new BufferedReader(new FileReader("E:\\Buoi5B2111903\\history_bill.txt"))){
            String line = new String("");
            while((line = br.readLine()) != null){
                
                String ma_kh = new String(line);
                
                history_bill hb = new history_bill();
                
                for(Customer c : lst_customer){
                    if(c.getMa_KH().equals(ma_kh)){
                        hb.setCustomer(c);
                    }
                }
                hb.setTongMua(Integer.parseInt(br.readLine()));
                
                lst_hb.add(hb);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return lst_hb;
    }
}
