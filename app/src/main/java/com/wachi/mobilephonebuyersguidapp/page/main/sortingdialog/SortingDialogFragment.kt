package com.wachi.mobilephonebuyersguidapp.page.main.sortingdialog

import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wachi.mobilephonebuyersguidapp.R
import kotlinx.android.synthetic.main.fragment_sorting_dialog.*

class SortingDialogFragment : DialogFragment() {

    enum class Sorting {
        PRICELOWTOHIGH, PRICEHIGHTOLOW, RATING, NONE
    }

    private var mCurrentSorting = Sorting.NONE

    private var mListener: SortingDialogListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sorting_dialog, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.radioPriceLowToHigh -> {
                    if ( mCurrentSorting != Sorting.PRICELOWTOHIGH) {
                        mCurrentSorting = Sorting.PRICELOWTOHIGH
                        mListener?.onSelectSorting(Sorting.PRICELOWTOHIGH, this)
                        dismiss()
                    }
                }
                R.id.radioPriceHighToLow -> {
                    if ( mCurrentSorting !=  Sorting.PRICEHIGHTOLOW) {
                        mCurrentSorting = Sorting.PRICEHIGHTOLOW
                        mListener?.onSelectSorting(Sorting.PRICEHIGHTOLOW, this)
                        dismiss()
                    }
                }
                R.id.radioRating -> {
                    if ( mCurrentSorting !=  Sorting.RATING) {
                        mCurrentSorting = Sorting.RATING
                        mListener?.onSelectSorting(Sorting.RATING, this)
                        dismiss()
                    }
                }
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is SortingDialogListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface SortingDialogListener {
        fun onSelectSorting(sorting: Sorting, dialog: SortingDialogFragment)
    }

    companion object {

        fun newInstance(): SortingDialogFragment {
            return SortingDialogFragment()
        }
    }
}// Required empty public constructor
