package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	var n int
	scanner.Scan()
	n, _ = strconv.Atoi(scanner.Text())
	a := make([]int, n)
	for i := 0; i < n; i++ {
		var j int
		scanner.Scan()
		j, _ = strconv.Atoi(scanner.Text())
		a[i] = j
	}

	max1 := -1
	max2 := -1
	for _, v := range a {
		if v > max1 {
			max2 = max1
			max1 = v
		} else if v > max2 {
			max2 = v
		}
	}

	ans := make([]string, n)
	for i := 0; i < n; i++ {
		if a[i] != max1 {
			ans[i] = fmt.Sprint(max1)
		} else {
			ans[i] = fmt.Sprint(max2)
		}
	}

	buf := strings.Join(ans, "\n")

	fmt.Print(buf)
}
