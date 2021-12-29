import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname NearestPoint
 * @Description TODO
 * @Date 2021/12/27 19:51
 * @Created by XJM
 */
public class NearestPoint_wa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            ArrayList<double[]> pointList = new ArrayList<>();
            String[] point_str = scanner.nextLine().split(",");
            pointList = toIntArray(point_str);
            ArrayList<double[]> res = new ArrayList<>();
            res = solution(pointList);
            sort(res);
            for (int j = 0; j <res.size()-1; j=j+2) {
                if(j!= res.size()-2){
                    System.out.print(BigDecimal.valueOf(res.get(j)[0]).stripTrailingZeros().toPlainString() + " " + BigDecimal.valueOf(res.get(j)[1]).stripTrailingZeros().toPlainString()
                            +","+BigDecimal.valueOf(res.get(j+1)[0]).stripTrailingZeros().toPlainString()+" "+BigDecimal.valueOf(res.get(j+1)[1]).stripTrailingZeros().toPlainString()+",");
                }else {
                    System.out.print(BigDecimal.valueOf(res.get(j)[0]).stripTrailingZeros().toPlainString() + " " + BigDecimal.valueOf(res.get(j)[1]).stripTrailingZeros().toPlainString()
                            +","+BigDecimal.valueOf(res.get(j+1)[0]).stripTrailingZeros().toPlainString()+" "+BigDecimal.valueOf(res.get(j+1)[1]).stripTrailingZeros().toPlainString());
                }

            }

        }
    }

    public static ArrayList<double[]> toIntArray(String[] strs) {
        ArrayList<double []> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String[] num_str = strs[i].split(" ");
            double[] arr = new double[num_str.length];
            for (int j = 0;j<num_str.length;j++){
                arr[j] = Double.valueOf(num_str[j]);
            }
            res.add(arr);
        }
        return res;
    }
    public static void sort(ArrayList<double []> pointList){
        for(int i=0;i<pointList.size();i++){
            for(int j=0;j< pointList.size()-i-1;j++){
                //System.out.println(pointList.get(j)[0]+" "+pointList.get(j+1)[0]);
                if(pointList.get(j)[0]>pointList.get(j+1)[0]){
                    swap(pointList.get(j),pointList.get(j+1));
                    //System.out.println("after"+pointList.get(j)[0]+" "+pointList.get(j+1)[0]);
                }
                if(pointList.get(j)[0]==pointList.get(j+1)[0]){
                    if (pointList.get(j)[1]>pointList.get(j+1)[1])
                        swap(pointList.get(j),pointList.get(j+1));
                }
            }
        }
        //System.out.println(pointList.get(3)[0]);
    }
    public static void swap(double[]mark1, double []mark2){
        for(int i=0;i<mark1.length;i++){
            double temp=mark1[i];
            mark1[i]=mark2[i];
            mark2[i]=temp;
        }
    }
    public static ArrayList<double []> solution(ArrayList<double []> pointList){
        ArrayList<double []> res = new ArrayList<>();
        if(pointList.size()==1){
            return res;
        }
        if(pointList.size()==2){
            return pointList;
        }
        double min=Integer.MAX_VALUE;
        for(int i=0;i<pointList.size();i++){
            for(int j=i+1;j<pointList.size();j++){
                double dis2 = Math.pow((pointList.get(j)[0]-pointList.get(i)[0]),2)+Math.pow((pointList.get(j)[1]-pointList.get(i)[1]),2);
                double dis = Math.pow(dis2,0.5);
                min=Math.min(min,dis);
            }

        }
        for(int i=0;i<pointList.size()-1;i++){
            for(int j=i+1;j<pointList.size();j++){
                double dis2 = Math.pow((pointList.get(j)[0]-pointList.get(i)[0]),2)+Math.pow((pointList.get(j)[1]-pointList.get(i)[1]),2);
                double dis = Math.pow(dis2,0.5);
                if(dis==min){
                    double []temp =new double[2];
                    temp[0]=pointList.get(i)[0];
                    temp[1]=pointList.get(i)[1];
                    double []temp1 =new double[2];
                    temp1[0]=pointList.get(j)[0];
                    temp1[1]=pointList.get(j)[1];
                    res.add(temp);
                    res.add(temp1);
                }
            }

        }
        return res;
    }
}
