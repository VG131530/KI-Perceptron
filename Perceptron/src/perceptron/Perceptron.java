package perceptron;

 public class Perceptron {  
      public final int numDimension;  
      private final double[] weightVector;
      private int weightVectorCount = 1;
      
      public Perceptron(int numInputs) {  
           this.numDimension = numInputs;  
           weightVector = new double[numInputs];  
           initializeWeights();  
      }  
      
      private void initializeWeights() {  
           for (int i=0; i<numDimension; i++) {  
                weightVector[i] = Math.random() * 0.1;
           }  
      }
      
      /**
       * Multiplicates the weight-vector with one testdata-entry
       * @param input testdata
     * @param data 
       * @return w*x (weighted-vector * input-vector)
       */
      public double getOutput(double[] input, String data) {  
           double result = 0.0;  
           for (int i=0; i<numDimension; i++) {  
                result += input[i] * weightVector[i];  
                String weigthVectorString = "w: " + Double.toString(weightVector[i]).substring(0, 6);
                String testDatString = "x: " + Double.toString(input[i]);
				System.out.println(weigthVectorString + " * " + testDatString +" = "+ Double.toString(result).substring(0, 6));
           }  
           System.out.println("Threshold: " + Double.toString(result));
           System.out.println("Data: " + data);
           System.out.println("_________________________________________________________");
           return result;  
      }  
      
      public void updateWeights(double[] inputSample, boolean addWeight) {  
    	  System.out.println("WeightVector: " + Integer.toString(++weightVectorCount));
           for (int i=0; i<numDimension; i++) {  
        	   if (addWeight) {
                weightVector[i] += Math.abs(inputSample[i]) * .3f;
        	   } else {
        		   weightVector[i] -= Math.abs(inputSample[i] * .3f);
        	   }
           } 	
      }

	public String getWeightVector() {
		String result = "\n";
		for (int i = 0; i < numDimension; i++) {
			result = result + Double.toString(this.weightVector[i]).substring(0, 6) + "\n";
		}
		return result;
	}  
 }  
