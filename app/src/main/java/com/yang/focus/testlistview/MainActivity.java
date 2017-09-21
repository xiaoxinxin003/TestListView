package com.yang.focus.testlistview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private ListView mListView;
    private TextView mEmptyView;
    private boolean hasData = false;
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();

        int nums[] = {2,6,5,11,8};
        int target = 10;
        solution(nums, target);
    }

    /**
     *
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:
     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
     * @param nums
     * @param target
     * @return
     */
    private int[] solution(int[] nums, int target) {
//        int results[] = new int[2];
//        int x = 0;
//        while (x < nums.length) {
//            for (int y  = x+1; y < nums.length; y++) {
//                if ((nums[x] + nums[y]) == target) {
//                    results[0] = x;
//                    results[1] = y;
//                    Log.d(TAG, "results is :" + results[0] + " and :" + results[1]);
//                    return results;
//                }
//            }
//            x++;
//        }
//        return results;

        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(hashmap.containsKey(nums[i])) {
                Log.d(TAG, "results is :" + hashmap.get(nums[i]) + " and :" + i);
                return new int[]{hashmap.get(nums[i]), i};
            } else {
                hashmap.put(target - nums[i], i);
            }
        }
        return null;
    }

    private void initView() {
        mListView = findViewById(R.id.list_view);
        mEmptyView = findViewById(R.id.tv_empty_data);
    }

    private void initData() {
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i=0;i<content.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("ico",imgIds[i]);
            map.put("title",title[i]);
            map.put("content",content[i]);
            listitem.add(map);
        }
        simpleAdapter = new SimpleAdapter(this,listitem,R.layout.main_list,new String[]{"title","content","ico"},new int[]{R.id.biaoti,R.id.content,R.id.ico});

        if (!hasData) {
            mListView.setEmptyView(mEmptyView);
        } else {
            mListView.setAdapter(simpleAdapter);
        }
    }

    private void initListener() {
        mEmptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasData = true;
                mListView.setAdapter(simpleAdapter);
            }
        });

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                                 int totalItemCount) {
                Log.d(TAG, "firstVisibleItem is :" + firstVisibleItem);
                Log.d(TAG, "visibleItemCount is :" + visibleItemCount);
                Log.d(TAG, "totalItemCount is :" + totalItemCount);
                if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
                    Log.d(TAG, "滚动到底部了");
                } else if (firstVisibleItem == 0) {
                    Log.d(TAG, "滚动到顶部了");
                }
            }
        });
    }

    //声明标题
    private String[] title = new String[]{
            "我是第1个Title",
            "我是第2个Title",
            "我是第3个Title",
            "我是第4个Title",
            "我是第1个Title",
            "我是第2个Title",
            "我是第3个Title",
            "我是第4个Title",
            "我是第1个Title",
            "我是第2个Title",
            "我是第3个Title",
            "我是第4个Title",
            "我是第1个Title",
            "我是第2个Title",
            "我是第3个Title",
            "我是第4个Title"
    };
    //声明内容
    private String[] content = new String[]{
            "我是第1个content",
            "我是第2个content",
            "我是第3个content",
            "我是第4个content",
            "我是第1个content",
            "我是第2个content",
            "我是第3个content",
            "我是第4个content",
            "我是第1个content",
            "我是第2个content",
            "我是第3个content",
            "我是第4个content",
            "我是第1个content",
            "我是第2个content",
            "我是第3个content",
            "我是第4个content"
    };
    //声明图标
    private int[] imgIds = new int[]{
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };
}
