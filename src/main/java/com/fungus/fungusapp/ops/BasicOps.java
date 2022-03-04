package com.fungus.fungusapp.ops;

import static com.fungus.fungusapp.model.ResultBuilder.getResult;
import static com.fungus.fungusapp.model.ResultBuilder.getResultFromError;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import com.fungus.fungusapp.model.ApiResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/basic")
public class BasicOps {
    @GetMapping("/add")
   public ApiResult add(@RequestParam BigDecimal augend, @RequestParam BigDecimal addend ) {
      return getResult(augend.add(addend));
   }

   @GetMapping("/subtract")
   public ApiResult subtract(@RequestParam BigDecimal minuent, @RequestParam BigDecimal subtrahend) {
      return getResult(minuent.subtract(subtrahend));
   }

   @GetMapping("/random")  
   public ApiResult random(@RequestParam(name="nItem",required=false) Integer nItem) {      
         if (nItem == null)
            return getResult(getRandoms(new Integer(10)));
         else
            return getResult(getRandoms(nItem));
   }
   

   @GetMapping("/multiply")
   public ApiResult multiply(@RequestParam BigDecimal multiplier, @RequestParam BigDecimal multiplicand) {
      return getResult(multiplier.multiply(multiplicand));
   }

   @GetMapping("/division")
   public ApiResult divide(@RequestParam BigDecimal dividend, @RequestParam BigDecimal divisor) {
      if (divisor.equals(BigDecimal.ZERO)) {
         return getResultFromError("no division by null");
      }
      return getResult(dividend.divide(divisor, RoundingMode.HALF_EVEN));
   }


   private Integer getRandom(){
      Random r = new Random();
      return  new Integer(r.nextInt());

   }

   private String getRandoms (Integer nItem){
      String result = "";
      for (int i = 0; i < nItem; i++) {
         result = result + "  "+ getRandom();
      };
      return result;
   }
}
