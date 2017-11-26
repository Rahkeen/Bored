package com.rikin.bored.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rikin.bored.R;
import com.rikin.bored.base.CustomApplication;
import com.rikin.bored.com.rikin.bored.model.repository.StreamsResponse;
import com.rikin.bored.com.rikin.bored.model.repository.TwitchService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class StreamListFragment extends Fragment {

    public static final String TAG = StreamListFragment.class.getCanonicalName();

    @Inject
    TwitchService twitchService;

    @BindView(R.id.stream_list)
    RecyclerView streamList;

    private final CompositeDisposable disposables = new CompositeDisposable();
    private final StreamListAdapter streamListAdapter = new StreamListAdapter();

    public static StreamListFragment newInstance() {
        return new StreamListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_stream_list, container, false);
        ButterKnife.bind(this, root);

        ((CustomApplication)getActivity().getApplication())
                .getSingletonComponent()
                .inject(this);

        streamList.setLayoutManager(new LinearLayoutManager(getContext()));
        streamList.setAdapter(streamListAdapter);

        twitchService.getStreams("21779")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<StreamsResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onSuccess(StreamsResponse streamsResponse) {
                        streamListAdapter.setData(streamsResponse.getData());
                        Log.d(TAG, "Success");
                    }

                    @Override
                    public void onError(Throwable e) {
                        throw new RuntimeException(e);
                    }
                });

        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        disposables.dispose();
    }
}
