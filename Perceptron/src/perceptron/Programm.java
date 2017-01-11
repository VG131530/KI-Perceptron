package perceptron;

public class Programm {
	
	 public static void main(String[] args) {  
		 Programm programm = new Programm();
         int numberOfDimension = 3;  
         
         double[][] trainingsData = new double[][] {  
                   {6, 1, 1}, // 1           
                   {7, 3, 1}, // 2           
                   {8, 2, 1}, // 3           
                   {9, 0, 1}, // 4          
                   {8, 4, 1}, // 5          
                   {8, 6, 1}, // 6          
                   {9, 2, 1}, // 7         
                   {9, 5, 1}  // 8         
         };  
         
         double[] expectedClasses = new double[] {  
              0,  // 1
              0,  // 2
              0,  // 3
              0,  // 4
              1,  // 5
              1,  // 6
              1,  // 7
              1   // 8
         };  
         
         Perceptron perceptron = new Perceptron(numberOfDimension);  
         while (true) {  
              for (int i=0; i<trainingsData.length; i++) { // for each TrainingData-Entry 
            	  double output = perceptron.getOutput(trainingsData[i], Integer.toString(i));
            	  double expectedOutput = expectedClasses[i];  
            	  
            	  if (expectedOutput == 0.0) { 
            		  if (output > 0) { // Element aus Klasse 0 korrekt zugeordnet
            			  continue;
            		  }
            		  System.out.println("Data: " + Integer.toString(i + 1) + " not correctly classified");
            		  perceptron.updateWeights(trainingsData[i], true); // remove
            		  i = 0;
            		  continue;
            		  
            	  } else if (expectedOutput == 1.0) {
            		  if (output <= 0) { // Element aus Klasse 1 korrekt zugeordnet
            			  continue;
            	  }
            		  System.out.println("Data: " + Integer.toString(i + 1) + " not correctly classified");
             	  perceptron.updateWeights(trainingsData[i], false); // add
            	  i = 0;
            	  continue;
            	  }
              }
              break;
         }
         programm.showResultsForInputSamples(trainingsData, expectedClasses, perceptron); 
    }
	 
    public void showResultsForInputSamples(double[][] inputs,double[] expectedOutputs, Perceptron perceptron) {  
         System.out.println("Found Solution with weight-vector: " + perceptron.getWeightVector());
    }
}
