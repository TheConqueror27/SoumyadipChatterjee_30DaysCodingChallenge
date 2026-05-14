#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int cmp(const void *a, const void *b)
{
    return strcmp(*(char **)a, *(char **)b);
}

void swap(char **a, char **b)
{
    char *temp = *a;
    *a = *b;
    *b = temp;
}

void reverse(char **s, int start, int end)
{
    while (start < end)
    {
        swap(&s[start], &s[end]);
        start++;
        end--;
    }
}

int next_permutation(int n, char **s)
{
    int i = n - 2;

    while (i >= 0 && strcmp(s[i], s[i + 1]) >= 0)
        i--;

    if (i < 0)
        return 0;

    int j = n - 1;

    while (strcmp(s[j], s[i]) <= 0)
        j--;

    swap(&s[i], &s[j]);

    reverse(s, i + 1, n - 1);

    return 1;
}