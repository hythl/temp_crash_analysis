import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class CleanMapper extends Mapper<LongWritable, Text, Text, DoubleWritable>{
    private static final int MISSING = 9999;
    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
	String[] fields = line.split(",");
        if(fields.length != 10){
            return;
        }
        double temp = 0;
        try {
            temp = Double.parseDouble(fields[1]);
        } catch(NumberFormatException e){
            return;
        }
        String newKey = fields[2]+','+fields[3]+','+fields[8];
        context.write(new Text(newKey), new DoubleWritable(temp));
    }
}
