package com.lxy.music.guid;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxy.music.R;


public class GuidFragment extends Fragment {

    //private FragmentGuidBinding mBinding;
    private Uri mUri;
    private CustomVideoView mCustomVideoView;


    public GuidFragment() {

    }

    public static GuidFragment newInstance() {
        return new GuidFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mCustomVideoView = new CustomVideoView(getActivity());

        String page = getArguments().getString("page");

        if ("1".equals(page)) {

            mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_1);

        } else if ("2".equals(page)) {

            mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_2);

        } else if ("3".equals(page)) {

            mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_3);
        }

        //mCustomVideoView.startPlay(mUri);

        return mCustomVideoView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            System.out.println("setUserVisibleHint======");
            //mCustomVideoView.startPlay(mUri);
            if (mCustomVideoView!=null) {
                mCustomVideoView.startPlay(mUri);
            }
        }else {
            if (mCustomVideoView!=null) {
                mCustomVideoView.stopPlayback();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mCustomVideoView != null) {
            mCustomVideoView.stopPlayback();
        }
    }
}
