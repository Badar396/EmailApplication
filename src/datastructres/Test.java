/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructres;

import java.time.LocalDate;

/**
 *
 * @author Badar Muneer
 */
public class Test 
{
    public static void main(String[] args)
    {
        LocalDate date=LocalDate.now();
        System.out.println(date);
        
        System.out.println(date.getDayOfMonth());
    }
}
