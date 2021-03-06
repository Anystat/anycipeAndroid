package com.anystat.anycipeandroid.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anystat.anycipeandroid.Data.Storage.ShoppingList;
import com.anystat.anycipeandroid.R;

import java.util.List;


public class BookListsFragment extends Fragment {

    // TODO: Customize parameters
    //private int mColumnCount = 1;
    private List<ShoppingList> dummyLists;
    private BookListsRecyclerViewAdapter.ViewHolder.BookListsClickListener mListener;
    //private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BookListsFragment() {


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.dummyLists = BookListsActivity.dummyLists;
        this.mListener = new BookListsRecyclerViewAdapter.ViewHolder.BookListsClickListener() {
            @Override
            public void onBookListsClickListener(int position) {
                Bundle args = new Bundle();
                args.putInt("position", position);
                ShoppingListFragment fragment = new ShoppingListFragment();
                fragment.setArguments(args);
                getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container_shopping_list_fragment, fragment).commit();
                //Toast.makeText(getContext(), dummyLists.get(position) + "", Toast.LENGTH_SHORT).show();
            }
        };

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booklists_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(new BookListsRecyclerViewAdapter(dummyLists, mListener));
        }
        return view;
    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnListFragmentInteractionListener) {
//            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onListFragmentInteraction(SListItem item);
//    }
}
