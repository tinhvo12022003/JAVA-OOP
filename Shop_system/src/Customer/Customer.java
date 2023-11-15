/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Customer extends Person{
    private String ma_KH;
    private int tong_mua;
    
    public Customer(){
        super();
        this.ma_KH = new String("");
        this.tong_mua = 0;
    }
    
    public Customer(String hoten, Date date, Address address, String phone, String ma_KH, int tong_mua){
        super(hoten, date, address, phone);
        this.ma_KH = new String(ma_KH);
        this.tong_mua = tong_mua;
    }
    
    public Customer(Customer c){
        super(c);
        this.ma_KH = new String(c.ma_KH);
        this.tong_mua = c.tong_mua;
    }
    
    public void setMa_KH(String ma_KH){
        this.ma_KH = new String(ma_KH);
    }
    
    public String getMa_KH(){
        return new String(new Customer(this).ma_KH);
    }
    
    public void setTongMua(int tong_mua){
        this.tong_mua = tong_mua;
    }
    
    public int getTongMua(){
        return new Customer(this).tong_mua;
    }
    
    @Override
    public String toString(){
        return new Customer(this).getMa_KH();
    }
    
    public ArrayList<Customer> readFile_Customer() {
        ArrayList<Customer> lst_customer = new ArrayList<>();
        String line = new String("");
        try (BufferedReader br = new BufferedReader(new FileReader("E:\\Buoi5B2111903\\customer.txt"))) {
            while ((line = br.readLine()) != null) {
                Customer c = new Customer();
                c.setHoten(line);

                Address addr = new Address();
                addr.setSoNha(br.readLine());
                addr.setXa(br.readLine());
                addr.setHuyen(br.readLine());
                addr.setTinh(br.readLine());
                c.setAddress(addr);

                Date d = new Date();
                String date = br.readLine();
                int ngay = Integer.parseInt(date.split("/")[0]);
                int thang = Integer.parseInt(date.split("/")[1]);
                int nam = Integer.parseInt(date.split("/")[2]);
                d.setNgay(ngay);
                d.setThang(thang);
                d.setNam(nam);
                c.setDate(d);

                c.setPhone(br.readLine());

                c.setMa_KH(br.readLine());

                lst_customer.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst_customer;
    }
}
