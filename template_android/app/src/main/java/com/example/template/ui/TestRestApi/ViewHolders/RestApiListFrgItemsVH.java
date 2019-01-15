package com.example.template.ui.TestRestApi.ViewHolders;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.template.R;
import com.example.template.model.bean.ItemRestApi;
import com.example.template.ui.TestRestApi.RestApiSingleAct;

import butterknife.BindView;
import butterknife.ButterKnife;

import static modules.general.utils.Constants.INPUT_KEY;
import static modules.general.utils.Constants.INPUT_KEY_CATEGORY_ID;
import static modules.general.utils.Constants.RestApiSingleAction;
import static modules.general.utils.Constants.RestApiSingleActionGet;
import static modules.general.utils.Constants.RestApiSingleSource;
import static modules.general.utils.Constants.RestApiSourceItems;

/**
 * Created by Net22 on 11/26/2017.
 */

public class RestApiListFrgItemsVH extends RecyclerView.ViewHolder {
    @BindView(R.id.tvHeading)
    TextView heading;
    @BindView(R.id.tvDescription)
    TextView desc;

    View itemView;
    int positionClicked;
    Object itemClicked;
    Context context;

    public RestApiListFrgItemsVH(Context context, View itemView) {
        super(itemView);
        this.context = context;
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public void bindData(final Object item, final int position) {

        final ItemRestApi itemInfo = (ItemRestApi) item;
        heading.setText(itemInfo.getName());
        desc.setText(itemInfo.getDescription());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                positionClicked = position;
                itemClicked = item;
                onClickItem(view, itemInfo);
            }
        });
    }

    public static View getView(Context context, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return layoutInflater.inflate(R.layout.row_rest_api_items, viewGroup, false);
    }

    public void onClickItem(View view, ItemRestApi itemInfo) {

        Intent intent = new Intent(context, RestApiSingleAct.class);
        intent.putExtra(RestApiSingleSource, RestApiSourceItems);
        intent.putExtra(RestApiSingleAction, RestApiSingleActionGet);
        intent.putExtra(INPUT_KEY, itemInfo.getId());
        intent.putExtra(INPUT_KEY_CATEGORY_ID, itemInfo.getCategory_id());
        context.startActivity(intent);

    }
}

