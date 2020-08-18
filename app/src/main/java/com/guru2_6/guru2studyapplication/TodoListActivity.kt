package com.guru2_6.guru2studyapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.guru2_6.guru2studyapplication.databinding.ActivityTodoListBinding

class TodoListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoListBinding

    private val data = arrayListOf<TodoListFragment.Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        data.add(TodoListFragment.Todo("과제 끝내기"))
        data.add(TodoListFragment.Todo("방 정리하기", true))

        fun toggleTodo(todo: TodoListFragment.Todo) {
            todo.isDone = !todo.isDone
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }

        fun addTodo() {
            val todo = TodoListFragment.Todo(binding.editTextTextPersonName.text.toString())
            data.add(todo)
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }

        fun deleteTodo(todo: TodoListFragment.Todo) {
            data.remove(todo)
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@TodoListActivity)
            adapter = TodoListFragment.TodoAdapter(data,
                onClickDeleteIcon = {
                    deleteTodo(it)
                },
                onClickItem = {
                    toggleTodo(it)
                }
            )
        }

        binding.addButton.setOnClickListener {
            addTodo()
        }


    }

}