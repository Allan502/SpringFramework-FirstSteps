package Test01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {

    @GetMapping("/validate-palindrome/{word}")
    public String validatePalindrome(@PathVariable String word){
        return isPalindrome(word);
    }

    private String isPalindrome(String word){
        String palindrome = "";
        for(int i = word.length()-1 ; i >= 0; i--){
            palindrome += word.charAt(i);
        }
        return word.equals(palindrome) ?
                "La palabra: "+ word + " es un palindromo" :
                "La palabra: "+ word +" no es un palindromo";
    }
}
