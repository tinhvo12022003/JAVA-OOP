/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Customer_VIP extends Customer{
    private String ma_KH_VIP;
    private int ma_giam;
    

    public Customer_VIP() {
        super();
        this.ma_KH_VIP = new String("");
        this.ma_giam = 0;
  
    }
    
    
    public Customer_VIP(String hoten, Date date, Address addr, String phone, String ma_KH, int tong_mua, String ma_KH_VIP, int ma_giam){
        super(hoten, date, addr, phone, ma_KH, tong_mua);
        this.ma_KH_VIP = new String(ma_KH_VIP);
        this.ma_giam = ma_giam;
        
    }

    public Customer_VIP(String ma_KH_VIP, int ma_giam) {
        this.ma_KH_VIP = ma_KH_VIP;
        this.ma_giam = ma_giam;
    }
    
    
    
    public Customer_VIP(Customer_VIP cv){
        super(cv.getHoten(), cv.getDate(), cv.getAddress(), cv.getPhone(), cv.getMa_KH(), cv.getTongMua());
        this.ma_KH_VIP = new String(cv.ma_KH_VIP);
        this.ma_giam = cv.ma_giam;
        
    }
    
    public void setMa_KH_VIP(String ma_KH_VIP){
        this.ma_KH_VIP = new String(ma_KH_VIP);
    }
    
    public String getMa_KH_VIP(){
        return new String(new Customer_VIP(this).ma_KH_VIP);
    }
    
    public void setMa_Giam(int ma_giam){
        this.ma_giam = ma_giam;
    }
    
    public int getMa_Giam(){
        return new Customer_VIP(this).ma_giam;
    }
    
    public ArrayList<Customer_VIP> readFileKH_VIP(){
        
        Customer customer = new Customer();
        
        ArrayList<Customer_VIP> lst_VIP = new ArrayList<>();
        
        ArrayList<Customer> lst_customer = new ArrayList<>(customer.readFile_Customer());
        
        String line = new String("");
        
        try(BufferedReader br = new BufferedReader(new FileReader("E:\\Buoi5B2111903\\KH_VIP.txt"))){
            while((line = br.readLine()) != null){
               
                String Ma_KH = new String(line);
                
                for(Customer c : lst_customer){
                    if(c.getMa_KH().equals(Ma_KH)){
                        
                       Customer_VIP cv = new Customer_VIP(c.getHoten(), c.getDate(), c.getAddress(), c.getPhone(), c.getMa_KH(), c.getTongMua(), c.getPhone() + "VIP", 10);
                        
                       lst_VIP.add(cv);
                        
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return  lst_VIP;
    }
}
