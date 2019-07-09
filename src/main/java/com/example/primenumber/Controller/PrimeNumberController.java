package com.example.primenumber.Controller;

import com.example.primenumber.Generators.TrialDivisionGenerator;
import com.example.primenumber.Generators.MillerRabinGenerator;
import com.example.primenumber.Generators.SieveGenerator;
import com.example.primenumber.Entity.Requests;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PrimeNumberController extends BaseController{


    @PostMapping(value = "/request")
    @ApiOperation("Takes in three parameters: Algorithm type [trial,sieve,miller], lower limit, upper limit")
    public List<Integer> getPrimes(@RequestBody Requests requests){
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStamp = simpleDateFormat.format(currentDate);

        ArrayList<Integer> result = new ArrayList<>();
        int lowerLimit = requests.getLowerLimit();
        int upperLimit = requests.getUpperLimit();
        String algorithmType = requests.getAlgorithmType();


        if(upperLimit < lowerLimit){
            throw new IllegalArgumentException("Upper limit must be larger than lower limit.");
        }

        long timeBefore = System.currentTimeMillis();

        if (requests.getAlgorithmType().equalsIgnoreCase("trial"))
        {
            ArrayList<Integer> primes = new TrialDivisionGenerator().generatePrime(lowerLimit,upperLimit);
            result.addAll(primes);
        }
        else if(requests.getAlgorithmType().equalsIgnoreCase("sieve"))
        {
            ArrayList<Integer> primes = new SieveGenerator().generatePrime(lowerLimit,upperLimit);
            result.addAll(primes);
        }
        else if (requests.getAlgorithmType().equalsIgnoreCase("miller"))
        {
            ArrayList<Integer> primes = new MillerRabinGenerator().generatePrime(lowerLimit,upperLimit);
            result.addAll(primes);

        }
        else{
            throw new UnsupportedOperationException("Algorithm type is not supported." +
                    " You can choose one of: 'trial', 'sieve'," +
                    " 'miller'");
        }
         long timeAfter = System.currentTimeMillis();
         long timeElapsed = timeAfter - timeBefore;

         Requests r = new Requests();
         r.setAlgorithmType(algorithmType);
         r.setLowerLimit(lowerLimit);
         r.setUpperLimit(upperLimit);
         r.setTimeElapsed(timeElapsed);
         r.setTimestamp(timeStamp);
         r.setNumberOfPrimes(result.size());
         requestService.save(r);

         return result;
    }
}
