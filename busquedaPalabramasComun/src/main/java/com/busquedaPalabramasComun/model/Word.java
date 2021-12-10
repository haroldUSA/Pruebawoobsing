/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.busquedaPalabramasComun.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                                                                   //Para no escribir los get y set
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    private String word;
    private String count;
}
