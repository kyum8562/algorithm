let arr;
let N, M;
const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];
function solution(maps) {
    arr = maps;
    N = maps.length;
    M = maps[0].length;
    
    return bfs();
}

function bfs(){
    const q = [];
    let time = 1;
    
    arr[0][0] = 0;
    q.push([0, 0]);
    
    while(q.length > 0){
        let qSize = q.length;
        
        for(let i = 0 ; i < qSize ; i ++){
            let [r, c] = q.shift();
            
            if(r == N-1 && c == M-1) return time;
            
            for(let d = 0 ; d < 4 ; d ++){
                let nr = r + dr[d];
                let nc = c + dc[d];
                
                if(!isValid(nr, nc) || arr[nr][nc] == 0) continue;
                q.push([nr, nc]);
                arr[nr][nc] = 0;
            }
        }
        
        time ++;
    }
    
    return -1;
}

function isValid(nr, nc){
    return(nr>=0 && nr<N && nc>=0 && nc<M);
}