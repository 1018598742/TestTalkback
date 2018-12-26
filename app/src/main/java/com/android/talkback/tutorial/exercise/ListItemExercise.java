/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.android.talkback.tutorial.exercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.talkback.R;

public class ListItemExercise extends Exercise implements AdapterView.OnItemClickListener {

    protected ListView mListView;

    @Override
    public View getContentView(final LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.tutorial_content_list, parent, false);
        mListView = (ListView) view.findViewById(R.id.list);
        ListAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 50;
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
                View view = inflater.inflate(R.layout.tutorial_content_list_item, parent, false);
                TextView title = (TextView) view.findViewById(R.id.title);
                String text = "List item " + (position + 1);
                title.setText(text);
                view.setContentDescription(text);
                return view;
            }
        };

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) { }
}
