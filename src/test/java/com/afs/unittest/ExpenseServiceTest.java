package com.afs.unittest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExpenseServiceTest {
    ExpenseService expenseService = new ExpenseService(new ProjectService());
    @Test
    void should_return_internal_expense_type_when_getExpenseCodeByProject_given_internal_project() {
        // given
        Project internalProject = new Project(ProjectType.INTERNAL, "Project Internal");

        // when
        ExpenseType expenseCodeByProject = expenseService.getExpenseCodeByProject(internalProject);

        // then
        Assertions.assertEquals(ExpenseType.INTERNAL_PROJECT_EXPENSE, expenseCodeByProject);

    }

    @Test
    void should_return_expense_type_A_when_getExpenseCodeByProject_given_project_is_external_and_name_is_project_A() {
        // given
        Project projectA = new Project(ProjectType.EXTERNAL, "Project A");

        // when
        ExpenseType expenseCodeByProject = expenseService.getExpenseCodeByProject(projectA);

        // then
        Assertions.assertEquals(ExpenseType.EXPENSE_TYPE_A, expenseCodeByProject);
    }

    @Test
    void should_return_expense_type_B_when_getExpenseCodeByProject_given_project_is_external_and_name_is_project_B() {
        // given
        Project projectB = new Project(ProjectType.EXTERNAL, "Project B");

        // when
        ExpenseType expenseCodeByProject = expenseService.getExpenseCodeByProject(projectB);

        // then
        Assertions.assertEquals(ExpenseType.EXPENSE_TYPE_B, expenseCodeByProject);
    }

    @Test
    void should_return_other_expense_type_when_getExpenseCodeByProject_given_project_is_external_and_has_other_name() {
        // given
        Project otherName = new Project(ProjectType.EXTERNAL, "Other Name");

        // when
        ExpenseType expenseCodeByProject = expenseService.getExpenseCodeByProject(otherName);

        // then
        Assertions.assertEquals(ExpenseType.OTHER_EXPENSE, expenseCodeByProject);
    }
}
