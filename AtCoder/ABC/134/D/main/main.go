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
	buffer := make([]byte, 200000)
	scanner.Buffer(buffer, 10*200000)
	var n int
	scanner.Scan()
	n, _ = strconv.Atoi(scanner.Text())
	a := make([]int, n)
	scanner.Scan()
	args := strings.Split(scanner.Text(), " ")
	for i := 0; i < n; i++ {
		var j int
		j, _ = strconv.Atoi(args[i])
		a[i] = j
	}

	b := make([]int, n)
	for i := n - 1; i >= 0; i-- {
		sum := 0
		for j := (i + 1) * 2; j <= n; j += (i + 1) {
			sum += b[j-1]
		}
		if a[i] != (sum % 2) {
			b[i] = 1
		} else {
			b[i] = 0
		}
	}

	ans := make([]string, n)
	m := 0
	for i := 0; i < n; i++ {
		if b[i] == 1 {
			ans[m] = fmt.Sprint(i + 1)
			m++
		}
	}

	buf := strings.Join(ans, " ")

	fmt.Println(m)
	if m != 0 {
		fmt.Println(buf)
	}
}
