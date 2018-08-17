package invenz.example.bijohn.fifawc2018.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bijohn.fifawc2018.R;
import invenz.example.bijohn.fifawc2018.model.MatchResult;

import java.util.List;

public class MatchResultCustomAdapter extends BaseAdapter{

    private Context context;
    private List<MatchResult> matchResults;

    public MatchResultCustomAdapter(Context context, List<MatchResult> matchResults) {
        this.context = context;
        this.matchResults = matchResults;
    }

    @Override
    public int getCount() {
        return matchResults.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.single_match_result, parent, false);
        }

        TextView tvMatchNo = convertView.findViewById(R.id.idMatchNo_result);
        TextView tvTeam1 = convertView.findViewById(R.id.idTeam1_result);
        TextView tvTeam2 = convertView.findViewById(R.id.idTeam2_result);
        TextView tvScore = convertView.findViewById(R.id.idScore_result);

        MatchResult matchResult = matchResults.get(position);

        tvMatchNo.setText(matchResult.getMatchNo());
        tvTeam1.setText(matchResult.getTeam1());
        tvTeam2.setText(matchResult.getTeam2());
        tvScore.setText(matchResult.getScore());

        return convertView;
    }
}
