package org.techtown.a1006_bibly;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;

public class TabFragment1_MyRecyclerViewAdapter_Small extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<BookInfo> bookInfos = new ArrayList<>();

    private Context mContext;
    private OnClickListener clickListener;

    int[][] dummyBookImage = {
            {R.drawable.dummy_1_1, R.drawable.dummy_1_2, R.drawable.dummy_1_3,
             R.drawable.dummy_1_4, R.drawable.dummy_1_5, R.drawable.dummy_1_6},

            {R.drawable.dummy_2_1, R.drawable.dummy_2_2, R.drawable.dummy_2_3,
             R.drawable.dummy_2_4, R.drawable.dummy_2_5, R.drawable.dummy_2_6},

            {R.drawable.dummy_3_1, R.drawable.dummy_3_2, R.drawable.dummy_3_3,
             R.drawable.dummy_3_4, R.drawable.dummy_3_5, R.drawable.dummy_3_6},

            {R.drawable.dummy_4_1, R.drawable.dummy_4_2, R.drawable.dummy_4_3,
             R.drawable.dummy_4_4, R.drawable.dummy_4_5, R.drawable.dummy_4_6}};


    public TabFragment1_MyRecyclerViewAdapter_Small(int index, Context context) {
        mContext = context;

        if (index == 0) {
            for (int i = 0; i < dummyBookImage.length; i++)
                for (int j = 0; j < dummyBookImage[0].length; j++)
                    bookInfos.add(new BookInfo(dummyBookImage[i][j],
                                        "book_" + (i + 1) + "_" + (j + 1),
                                        "author_" + (i + 1) + "_" + (j + 1)));

        } else if (index == 1) {
            for (int i = 0; i < dummyBookImage[0].length; i++)
                bookInfos.add(new BookInfo(dummyBookImage[0][i],
                                        "book_" + index + "_" + (i + 1),
                                        "author_" + index + "_" + (i + 1) ));

        } else if (index == 2) {
            for (int i = 0; i < dummyBookImage[1].length; i++)
                bookInfos.add(new BookInfo(dummyBookImage[1][i],
                                        "book_" + index + "_" + (i + 1),
                                        "author_" + index + "_" + (i + 1) ));

        } else if (index == 3) {
            for (int i = 0; i < dummyBookImage[2].length; i++)
                bookInfos.add(new BookInfo(dummyBookImage[2][i],
                                        "book_" + index + "_" + (i + 1),
                                        "author_" + index + "_" + (i + 1) ));

        } else if (index == 4) {
            for (int i = 0; i < dummyBookImage[3].length; i++)
                bookInfos.add(new BookInfo(dummyBookImage[3][i],
                        "book_" + index + "_" + (i + 1),
                        "author_" + index + "_" + (i + 1) ));
        }


    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //XML 가져오는 부분
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_fragment_1_recyclerview_item_small, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //데이터를 넣어주는 부분. 바인딩하는 부분
        ((ViewHolder) holder).book.setImageResource(bookInfos.get(position).book);
        ((ViewHolder) holder).ratingBar.setRating(bookInfos.get(position).rate);



    }

    @Override
    public int getItemCount() {
        //카운터
        return bookInfos.size();
    }

    public void setClickListener(OnClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }


    //소스코드 절약해주는 부분 static 넣으면 더 좋음
    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView book;
        RatingBar ratingBar;

        public ViewHolder(View view) {
            super(view);

            book = (ImageView) view.findViewById(R.id.dummy_book);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();

                    // check if item still exists
                    if(pos != RecyclerView.NO_POSITION){
                        Toast.makeText(v.getContext(), "You clicked " + pos, Toast.LENGTH_SHORT).show();
                    }

                    if (clickListener != null)
                        clickListener.onBookClick(bookInfos.get(pos));


                }
            });
        }
    }
}
