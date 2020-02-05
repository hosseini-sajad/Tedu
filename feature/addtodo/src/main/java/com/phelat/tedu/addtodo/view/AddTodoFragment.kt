package com.phelat.tedu.addtodo.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.phelat.tedu.addtodo.R
import com.phelat.tedu.addtodo.di.component.AddTodoComponent
import com.phelat.tedu.daggerandroid.Injector
import com.phelat.tedu.todo.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.fragment_addtodo.saveTodo
import kotlinx.android.synthetic.main.fragment_addtodo.todoInput
import javax.inject.Inject

class AddTodoFragment : Fragment(R.layout.fragment_addtodo) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val todoViewModel by activityViewModels<TodoViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        Injector.inject(AddTodoComponent::class,this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveTodo.setOnClickListener {
            val todo = todoInput.text.toString()
            todoViewModel.onSaveTodoClicked(todo)
        }
    }

}