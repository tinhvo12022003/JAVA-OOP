/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bill;

import Customer.*;
import Goods.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.time.*;

/**
 *
 * @author hp
 */
public class detail_bill {
    private product pd;
    private int so_luong_mua;
    
    public detail_bill(){
        int so_luong = 0;
        this.pd = new product();
    }
    
    public detail_bill(product pd, int so_luong){
        this.so_luong_mua = so_luong;
        this.pd = new product(pd);
    }
    
    public detail_bill(detail_bill db){
        this.so_luong_mua = db.so_luong_mua;        
        this.pd = new product(db.pd);
    }
    
    public void setProduct(product p){
        this.pd = new product(p);
    }
    
    public product getproduct(){
        return new detail_bill(this).pd;
    }
    
    public void setSoluongMua(int so_luong_mua){
        this.so_luong_mua = so_luong_mua;
    }
    
    public int getSoluongMua(){
        return new detail_bill(this).so_luong_mua;
    }
    
    public ArrayList<detail_bill> readFile_detail() throws IOException{
        ArrayList<detail_bill> lst_detail_bill = new ArrayList<>();
        
        product p = new product();
        
        ArrayList<product> readFileProduct = new ArrayList<>(p.readFile_products());
        
        
        int so_luong = 0;
        String line = new String("");
        
        try(BufferedReader br = new BufferedReader(new FileReader("E:\\Buoi5B2111903\\detail_bill.txt"))){
            while((line = br.readLine()) != null){
                
                detail_bill dt = new detail_bill();
                
                for(product temp : readFileProduct){
                    if(temp.getMa_sp().equals(line)){
                        dt.setProduct(temp);
                    }
                }
                
                dt.setSoluongMua(Integer.parseInt(br.readLine()));
                
                lst_detail_bill.add(dt);
            }
                    
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return lst_detail_bill;
    }
}
