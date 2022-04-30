package com.example.m4l6t3.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m4l6t3.R

import android.content.Context

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m4l6t3.Member
import com.example.m4l6t3.adapter.MainAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        refreshAdapter(prepareMemberList())

    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..15) members.add(Member())
        return members
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = MainAdapter(context, members)
        recyclerView.adapter = adapter
    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.rv_main_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        recyclerView.isNestedScrollingEnabled = false
    }
}