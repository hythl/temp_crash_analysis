import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class CleanReducer extends Reducer<Text, DoubleWritable, Text, NullWritable>{
    @Override
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {
        double sum = 0;
        int count = 0;
        for (DoubleWritable value : values) {
            sum += value.get();
            count+=1;
        }
        double avgTemp = sum/count;
        context.write(new Text((key.toString()+","+avgTemp)),NullWritable.get());
    }
}
