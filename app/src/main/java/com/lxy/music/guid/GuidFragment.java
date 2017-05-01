package com.lxy.music.guid;


import android.net.Uri;

import com.lxy.music.R;
import com.lxy.music.base.GuidBaseFragment;


public class GuidFragment extends GuidBaseFragment {

    private Uri mUri;
    private CustomVideoView mCustomVideoView;


    public GuidFragment() {

    }

    public static GuidFragment newInstance() {
        return new GuidFragment();
    }

    @Override
    protected void lazyLoadData() {

        mCustomVideoView = mBinding.customVideoView;

        String page = getArguments().getString("page");

        if ("1".equals(page)) {

            mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_1);

        } else if ("2".equals(page)) {

            mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_2);

        } else if ("3".equals(page)) {

            mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_3);
        }

        mCustomVideoView.startPlay(mUri);
    }

    @Override
    protected int getResourceId() {

        return R.layout.fragment_guid;
    }

    @Override
    protected void stopLoadData() {
        if (mCustomVideoView != null) {
            mCustomVideoView.stopPlayback();
        }
    }

}
